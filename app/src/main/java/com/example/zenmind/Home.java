package com.example.zenmind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity  {

    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#4491A7"));
    }
    CardView yoga, sleep,meditation, breath, workout, about, contact, logout;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Home.this, LoginScreen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        yoga =findViewById(R.id.yogaCard);
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, YogaScreen.class));
            }
            });
        sleep =findViewById(R.id.sleepCard);
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MusicList.class));
            }
        });
        meditation =findViewById(R.id.meditationCard);
        meditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, HealthArticle.class));
            }
        });
        breath =findViewById(R.id.breathCard);
        breath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, NewBreathingActivity.class));
            }
        });
        workout =findViewById(R.id.workoutCard);
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, FitnessScreen.class));
            }
        });
        about =findViewById(R.id.profileCard);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, ProfileScreen.class));
            }
        });
        contact =findViewById(R.id.contactCard);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, ContactCard.class));
            }
        });
        logout =findViewById(R.id.logoutCard);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Home.this, LoginScreen.class));
            }
        });


    }
}