package com.example.zenmind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginScreen extends AppCompatActivity {

    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null){
            Toast.makeText(LoginScreen.this,"Previously Logged In",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginScreen.this, Home.class));
            finish();


        }
        getWindow().setStatusBarColor(Color.parseColor("#0B3455"));
    }
    TextView LoginEmail,LoginPassword,gotosignup;
    Button button2;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(LoginScreen.this, StartScreen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        LoginEmail = findViewById(R.id.LoginEmail);
        gotosignup = findViewById(R.id.textviewSignup);
        LoginPassword = findViewById(R.id.LoginPassword);
        button2 = findViewById(R.id.button2);
        mAuth = FirebaseAuth.getInstance();
        mUser =mAuth.getCurrentUser();


        button2.setOnClickListener(view -> {
            loginuser();
        });
        gotosignup.setOnClickListener(view -> {
            startActivity(new Intent(LoginScreen.this, SignupScreen.class));
        });

    }

    private void loginuser() {
        String email = LoginEmail.getText().toString();
        String password = LoginPassword.getText().toString();
        if (TextUtils.isEmpty(email)){
            LoginEmail.setError("Email Cannot Be Empty");
            LoginEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            LoginPassword.setError("Password Cannot Be Empty");
            LoginPassword.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        if (mAuth.getCurrentUser().isEmailVerified()){
                            startActivity(new Intent(LoginScreen.this, Home.class));
                            Toast.makeText(LoginScreen.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(LoginScreen.this,"Please Verify Your Email", Toast.LENGTH_SHORT).show();

                        }

                    }else {
                        Toast.makeText(LoginScreen.this,"Login Failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


}
