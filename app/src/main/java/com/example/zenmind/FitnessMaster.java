package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FitnessMaster extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FitnessMaster.this, FitnessScreen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_master);
        LinearLayout P1 =findViewById(R.id.p1);
        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessMaster.this,FitnessMP1.class);
                startActivity(intent1);
            }
        });

        LinearLayout P2 =findViewById(R.id.p2);
        P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessMaster.this,FitnessMP2.class);
                startActivity(intent1);
            }
        });

        LinearLayout P3 =findViewById(R.id.p3);
        P3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessMaster.this,FitnessMP3.class);
                startActivity(intent1);
            }
        });
    }
}