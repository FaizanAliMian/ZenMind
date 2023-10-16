package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UpdateProfile extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#0B3455"));
    }
    EditText UpdateName, UpdateNumber, UpdateCountry;
    ImageView EditProfile;
    Button UpdateProfile;
    FirebaseFirestore fstore;

    String userID;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        UpdateName = findViewById(R.id.EditFullName);
        UpdateNumber = findViewById(R.id.EditPhoneNumber);
        UpdateCountry = findViewById(R.id.EditCountry);
        UpdateProfile = findViewById(R.id.UpdateProfile);
        fstore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        UpdateProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                performUpdate();
            }

            private void performUpdate() {
                String Name = UpdateName.getText().toString();
                String Phone = UpdateNumber.getText().toString();
                String country = UpdateCountry.getText().toString();
                userID = mAuth.getCurrentUser().getUid();
                DocumentReference documentReference = fstore.collection("users").document(userID);
                Map<String, Object> user = new HashMap<>();
                user.put("Full Name", Name);
                user.put("Phone Number", Phone);
                user.put("Country", country);
                documentReference.set(user, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateProfile.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                        sendUserToNextActivity();
                    }

                    private void sendUserToNextActivity() {
                        Intent intent = new Intent(UpdateProfile.this, ProfileScreen.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }
        });
    }}