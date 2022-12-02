package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

public class videoBasedStartup extends AppCompatActivity {

    Button solutionButton;
    Button screeningButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_based_startup);

        solutionButton = findViewById(R.id.solutionButton);
        screeningButton = findViewById(R.id.screeningButton);

        screeningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(videoBasedStartup.this, VideoBasedScreeningTest3.class);
                startActivity(intent);
            }
        });

        solutionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(videoBasedStartup.this, videoBasedSolution.class);
                startActivity(intent);
            }
        });
    }


}
