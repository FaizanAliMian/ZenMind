package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FitnessBeginner extends AppCompatActivity {

    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#9b74d9"));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FitnessBeginner.this, FitnessScreen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_beginner);
        LinearLayout P1 =findViewById(R.id.p1);
        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessBeginner.this,FitnessBP1.class);
                startActivity(intent1);
            }
        });

        LinearLayout P2 =findViewById(R.id.p2);
        P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessBeginner.this,FitnessBP2.class);
                startActivity(intent1);
            }
        });

        LinearLayout P3 =findViewById(R.id.p3);
        P3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessBeginner.this,FitnessBP3.class);
                startActivity(intent1);
            }
        });
    }
}