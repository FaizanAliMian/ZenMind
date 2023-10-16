package com.example.zenmind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignupScreen extends AppCompatActivity {

    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#0B3455"));
    }
    public static final String TAG = "TAG";
    EditText SignupFullName,LoginEmail,LoginPassword,ConfirmPassword,PhoneNumber,Country;
    Button button;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseFirestore fstore;
    String userID;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SignupScreen.this, StartScreen.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        TextView btn = findViewById(R.id.AlreadyAccount);
        SignupFullName =findViewById(R.id.SignupFullName);
        LoginEmail =findViewById(R.id.LoginEmail);
        LoginPassword =findViewById(R.id.LoginPassword);
        ConfirmPassword =findViewById(R.id.ConfirmPassword);
        PhoneNumber =findViewById(R.id.PhoneNumber);
        Country = findViewById(R.id.country);
        button =findViewById(R.id.button);
        mAuth =FirebaseAuth.getInstance();
        mUser =mAuth.getCurrentUser();
        fstore = FirebaseFirestore.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupScreen.this,LoginScreen.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });
    }

    private void PerformAuth() {
        String Name=SignupFullName.getText().toString();
        String Email=LoginEmail.getText().toString();
        String Password=LoginPassword.getText().toString();
        String ConfirmPass=ConfirmPassword.getText().toString();
        String Phone=PhoneNumber.getText().toString();
        String country=Country.getText().toString();

        if (!Email.matches(emailPattern))
        {
            LoginEmail.setError("Enter valid Email");
            LoginEmail.requestFocus();
        } else if (Name.isEmpty()) {
            SignupFullName.setError("Enter Full Name");
            SignupFullName.requestFocus();
        } else if (Password.isEmpty() || Password.length()<6) {
            LoginPassword.setError("Enter Valid Password");
            LoginPassword.requestFocus();
        } else if (!Password.equals(ConfirmPass)) {
            ConfirmPassword.setError("Password Not Match");
            ConfirmPassword.requestFocus();
        }
            else if (Phone.isEmpty()){
                PhoneNumber.setError("Enter Phone Number");
                PhoneNumber.requestFocus();
            }
        else {
            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignupScreen.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(SignupScreen.this,"User Profile is Created Kindly Verify Email Address",Toast.LENGTH_SHORT).show();

                                }

                            }
                        });
                        userID = mAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = fstore.collection("users").document(userID);
                        Map<String,Object> user = new HashMap<>();
                        user.put("Full Name",Name);
                        user.put("Email",Email);
                        user.put("Password",Password);
                        user.put("Phone Number",Phone);
                        user.put("Country",country);
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d(TAG, "onSuccess: User Profile is Created" + userID);
                            }
                        });
                        sendUserToNextActivity();
                    }else{
                        Toast.makeText(SignupScreen.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent =new Intent(SignupScreen.this,LoginScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}