package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FitnessScreen extends AppCompatActivity {
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#9b74d9"));
    }

    Button button1, button2, button3;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FitnessScreen.this, Home.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_screen);
        LinearLayout linearLayout =findViewById(R.id.beginner);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vp) {
                Intent intent = new Intent(FitnessScreen.this,FitnessBeginner.class);
                startActivity(intent);

            }
        });
        LinearLayout linearLayout1 =findViewById(R.id.intermediate);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessScreen.this,FitnessIntermediate.class);
                startActivity(intent1);

            }
        });
        LinearLayout linearLayout2 =findViewById(R.id.master);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent intent2 = new Intent(FitnessScreen.this,FitnessMaster.class);
                startActivity(intent2);

            }
        });

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        button1 = findViewById(R.id.do1);
        button2 = findViewById(R.id.do2);
        button3 = findViewById(R.id.do3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vo) {
                Intent intont = new Intent(FitnessScreen.this,FitnessBeginner.class);
                startActivity(intont);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ve) {
                Intent intant = new Intent(FitnessScreen.this,FitnessIntermediate.class);
                startActivity(intant);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vr) {
                Intent into = new Intent(FitnessScreen.this,FitnessMaster.class);
                startActivity(into);
            }
        });
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }}