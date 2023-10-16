package com.example.zenmind;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewBreathingActivity extends AppCompatActivity {
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(Color.parseColor("#E4E4E4"));
    }

    private TextView quoteTextView;
    private Button getQuoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_breathing);
        quoteTextView = findViewById(R.id.quoteTextView);
        getQuoteButton = findViewById(R.id.getQuoteButton);

        getQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get a random quote from the string-array
                String[] quotes = getResources().getStringArray(R.array.quotes);
                int randomIndex = (int) (Math.random() * quotes.length);
                String randomQuote = quotes[randomIndex];

                // Update the TextView with the random quote
                quoteTextView.setText(randomQuote);
            }
        });
    }
}
