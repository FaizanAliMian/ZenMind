package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactCard extends AppCompatActivity {

    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#42cafe"));
    }

//    Button button;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_card);
//        button = findViewById(R.id.Done);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ContactCard.this, Home.class);
//                startActivity(intent);
    }
}