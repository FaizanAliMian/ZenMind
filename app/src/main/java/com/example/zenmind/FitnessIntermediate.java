package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FitnessIntermediate extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FitnessIntermediate.this, FitnessScreen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_intermediate);
        LinearLayout P1 =findViewById(R.id.p1);
        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessIntermediate.this,FitnessIP1.class);
                startActivity(intent1);
            }
        });

        LinearLayout P2 =findViewById(R.id.p2);
        P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessIntermediate.this,FitnessIP2.class);
                startActivity(intent1);
            }
        });

        LinearLayout P3 =findViewById(R.id.p3);
        P3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(FitnessIntermediate.this,FitnessIP3.class);
                startActivity(intent1);
            }
        });
    }
}