package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class HealthArticle extends AppCompatActivity {
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#61A3BD"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article);
    }
}