package com.example.zenmind;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.Objects;
import java.util.UUID;


public class ProfileScreen extends AppCompatActivity {

    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#42CAFE"));
    }



    TextView mAccFullName, mAccEmail, mAccPhoneNo, mAccAddress, country,mAccEditProfilePic,username,upperemail;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId;
    Button Update;

    ImageView mAccProfilePic;
    StorageReference storageReference;
    private Uri selectedImageUri;
    private ActivityResultLauncher<Intent> galleryLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        mAccFullName = findViewById(R.id.accFullName);
        mAccEmail = findViewById(R.id.accEmail);
        username = findViewById(R.id.username);
        upperemail = findViewById(R.id.upperemail);
        mAccPhoneNo = findViewById(R.id.accPhoneNo);
        country = findViewById(R.id.accAddress);
        mAccProfilePic = findViewById(R.id.accProfilePic);
        mAccEditProfilePic = findViewById(R.id.accEditProfilePic);
        Update = findViewById(R.id.UpdateButton);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        userId = mAuth.getCurrentUser().getUid();

        galleryLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        selectedImageUri = result.getData().getData();
                        mAccProfilePic.setImageURI(selectedImageUri);
                        uploadImageToFirebaseStorage(selectedImageUri);
                    }
                });
        mAccEditProfilePic.setOnClickListener(v -> openGallery());
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileScreen.this, UpdateProfile.class);
                startActivity(intent);
            }
        });


        fStore.collection("users").document(userId).get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()){
                String fullname = documentSnapshot.getString("Full Name");
                String email = documentSnapshot.getString("Email");
                String phone = documentSnapshot.getString("Phone Number");
                String countr = documentSnapshot.getString("Country");
                mAccFullName.setText(fullname);
                mAccEmail.setText(email);
                mAccPhoneNo.setText(phone);
                country.setText(countr);
                upperemail.setText(email);
                username.setText(fullname);


                String imageUrl = documentSnapshot.getString("profileImageUrl");
                if (imageUrl != null) {
                    Picasso.get().load(imageUrl).into(mAccProfilePic);
                }
            }
        }).addOnFailureListener(e -> {
            String errorMessage = "Error fetching data: " + e.getMessage();
            mAccFullName.setText(errorMessage);
            mAccEmail.setText(errorMessage);
            mAccPhoneNo.setText(errorMessage);
            mAccAddress.setText(errorMessage);

        });
    }
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryLauncher.launch(intent);
    }
    private void uploadImageToFirebaseStorage(Uri imageUri) {
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();

        String imageName = UUID.randomUUID().toString();
        StorageReference imageRef = storageRef.child("images/" + imageName);

        imageRef.putFile(imageUri)
                .addOnSuccessListener(taskSnapshot -> {
                    imageRef.getDownloadUrl()
                            .addOnSuccessListener(downloadUri -> {
                                String imageUrl = downloadUri.toString();
                                updateImageUrlInFirestore(imageUrl);
                            })
                            .addOnFailureListener(e -> {
                                Toast.makeText(ProfileScreen.this, "Error Getting Image URL", Toast.LENGTH_SHORT).show();
                            });

                })
                .addOnFailureListener(e -> {
                    Toast.makeText(ProfileScreen.this, "Error Uploading Image", Toast.LENGTH_SHORT).show();
                });
    }
    private void updateImageUrlInFirestore(String imageUrl) {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference userRef = FirebaseFirestore.getInstance().collection("users").document(userId);

        userRef.update("profileImageUrl", imageUrl)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(ProfileScreen.this, "Image Uploaded Successfully", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(ProfileScreen.this, "Error updating image URL", Toast.LENGTH_SHORT).show();
                });

    }
}
