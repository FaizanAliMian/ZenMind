package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class BeginnerScreen extends AppCompatActivity {
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#FF8F7B"));
    }




    @Override
public void onBackPressed() {
    super.onBackPressed();
    Intent intent = new Intent(BeginnerScreen.this, YogaScreen.class);
    startActivity(intent);
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_screen);
        LinearLayout P1 =findViewById(R.id.p1);
        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(BeginnerScreen.this,YogaBP1.class);
                startActivity(intent1);
            }
        });

        LinearLayout P2 =findViewById(R.id.p2);
        P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(BeginnerScreen.this,YogaBP2.class);
                startActivity(intent1);
            }
        });

        LinearLayout P3 =findViewById(R.id.p3);
        P3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(BeginnerScreen.this,YogaBP3.class);
                startActivity(intent1);
            }
        });

        LinearLayout P4 =findViewById(R.id.p4);
        P4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(BeginnerScreen.this,YogaBP4.class);
                startActivity(intent1);
            }
        });

        LinearLayout P5 =findViewById(R.id.p5);
        P5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(BeginnerScreen.this,YogaBP5.class);
                startActivity(intent1);
            }
        });

        LinearLayout P6 =findViewById(R.id.p6);
        P6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(BeginnerScreen.this,YogaBP6.class);
                startActivity(intent1);
            }
        });
        



    }
}