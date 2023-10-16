package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class YogaScreen extends AppCompatActivity {
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#FF8F7B"));
    }

    Button button1,button2,button3;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(YogaScreen.this, Home.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_screen);
        LinearLayout linearLayout =findViewById(R.id.beginner);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vp) {
                Intent intent = new Intent(YogaScreen.this,BeginnerScreen.class);
                startActivity(intent);

            }
        });
        LinearLayout linearLayout1 =findViewById(R.id.intermediate);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vl) {
                Intent intent1 = new Intent(YogaScreen.this,IntermediateScreen.class);
                startActivity(intent1);

            }
        });
        LinearLayout linearLayout2 =findViewById(R.id.master);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent intent2 = new Intent(YogaScreen.this,MasterScreen.class);
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
                Intent intont = new Intent(YogaScreen.this,BeginnerScreen.class);
                startActivity(intont);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ve) {
                Intent intant = new Intent(YogaScreen.this,IntermediateScreen.class);
                startActivity(intant);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vr) {
                Intent into = new Intent(YogaScreen.this,MasterScreen.class);
                startActivity(into);
            }
        });
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }}