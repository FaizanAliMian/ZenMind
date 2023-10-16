package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class StartScreen extends AppCompatActivity {

    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null){
            Toast.makeText(StartScreen.this,"Previously Logged In",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(StartScreen.this, Home.class));
            finish();


        }
        getWindow().setStatusBarColor(Color.parseColor("#038C8A"));
    }
    FirebaseAuth mAuth;
    private static final long BACK_PRESS_THRESHOLD = 2000; // 2 seconds
    private long backPressTime;
    Button btn1, btn2;
    private boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are You Sure You Want To Exit")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No",null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        btn1 = findViewById(R.id.gotologin);
        btn2 = findViewById(R.id.gotosignup);
        mAuth = FirebaseAuth.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartScreen.this,LoginScreen.class));
            }


        });
        btn2 = findViewById(R.id.gotosignup);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartScreen.this, SignupScreen.class));
            }
        });
    }
}