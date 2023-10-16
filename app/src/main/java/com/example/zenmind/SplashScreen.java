package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class SplashScreen extends AppCompatActivity {
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#FF000000"));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        VideoView videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://com.example.zenmind/" + getPackageName() + "/" + R.raw.splash);
        videoView.setVideoURI(videoUri);

        videoView.setOnCompletionListener(mp -> {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, StartScreen.class);
                    startActivity(intent);
                    finish();
                }
            },500);
        });

        videoView.start();
    }
}