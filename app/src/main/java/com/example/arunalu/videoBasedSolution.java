package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class videoBasedSolution extends AppCompatActivity {

    Button buttonWord2;
    Button buttonWord3;
    Button buttonWord4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_based_solution);

        buttonWord2 = findViewById(R.id.screeningWord2);
        buttonWord3 = findViewById(R.id.screeningWord3);
        buttonWord4 = findViewById(R.id.screeningWord4);

        buttonWord2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(videoBasedSolution.this, VideoBasedSolutionTest1.class);
                startActivity(intent);
            }
        });

        buttonWord3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(videoBasedSolution.this, VideoBasedSolutionTest4.class);
                startActivity(intent);
            }
        });

        buttonWord4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(videoBasedSolution.this, VideoBasedSolutionTest6.class);
                startActivity(intent);
            }
        });
    }
}
