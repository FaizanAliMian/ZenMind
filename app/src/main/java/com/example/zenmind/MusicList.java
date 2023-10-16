package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MusicList extends AppCompatActivity {
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MusicList.this, Home.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);


        LinearLayout A1 =findViewById(R.id.music1);
        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View va) {
                Intent intentA = new Intent(MusicList.this,Music1.class);
                startActivity(intentA);
            }
        });
        LinearLayout A2 =findViewById(R.id.music2);
        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vb) {
                Intent intentB = new Intent(MusicList.this,Music2.class);
                startActivity(intentB);
            }
        });
        LinearLayout A3 =findViewById(R.id.music3);
        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vc) {
                Intent intentC = new Intent(MusicList.this,Music3.class);
                startActivity(intentC);
            }
        });
        LinearLayout A4 =findViewById(R.id.music4);
        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vd) {
                Intent intentD = new Intent(MusicList.this,Music4.class);
                startActivity(intentD);
            }
        });
        LinearLayout A5 =findViewById(R.id.music5);
        A5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ve) {
                Intent intentE = new Intent(MusicList.this,Music5.class);
                startActivity(intentE);
            }
        });
        LinearLayout A6 =findViewById(R.id.music6);
        A6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vf) {
                Intent intentF = new Intent(MusicList.this,Music6.class);
                startActivity(intentF);
            }
        });
        LinearLayout A7 =findViewById(R.id.music7);
        A7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vg) {
                Intent intentG = new Intent(MusicList.this,Music7.class);
                startActivity(intentG);
            }
        });
        LinearLayout A8 =findViewById(R.id.music8);
        A8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vh) {
                Intent intentH = new Intent(MusicList.this,Music8.class);
                startActivity(intentH);
            }
        });
        LinearLayout A9 =findViewById(R.id.music9);
        A9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent intentI = new Intent(MusicList.this,Music9.class);
                startActivity(intentI);
            }
        });
        LinearLayout A10 =findViewById(R.id.music10);
        A10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vj) {
                Intent intentJ = new Intent(MusicList.this,Music10.class);
                startActivity(intentJ);
            }
        });
        LinearLayout A11 =findViewById(R.id.music11);
        A11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vk) {
                Intent intentK = new Intent(MusicList.this,SleepScreen.class);
                startActivity(intentK);
            }
        });
    }
}