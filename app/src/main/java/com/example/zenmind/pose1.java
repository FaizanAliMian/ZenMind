package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class pose1 extends AppCompatActivity {
    private CountDownTimer countdownTimer;
    Button button1,button2,countdownButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pose1);
        countdownButton = findViewById(R.id.countdownButton);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.text);

            countdownButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startCountdown();
                }
            });

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(pose1.this, pose1.class);
                    startActivity(intent);
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to Activity2
                    Intent intent = new Intent(pose1.this, pose1.class);
                    startActivity(intent);
                }
            });
        }

        private void startCountdown() {
            countdownTimer = new CountDownTimer(60000, 1000) {
                public void onTick(long millisUntilFinished) {
                    textView.setText("Timer:" + millisUntilFinished/1000);
                }

                public void onFinish() {
                    textView.setText("Done");
                }
            }.start();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            if (countdownTimer != null) {
                countdownTimer.cancel();
            }
        }

    }