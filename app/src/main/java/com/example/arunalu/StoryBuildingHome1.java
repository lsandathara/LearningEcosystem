package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StoryBuildingHome1 extends AppCompatActivity {

    Button screeningbtn, solutionbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_building_home1);

        screeningbtn = (Button) findViewById(R.id.screeningbtn);
        solutionbtn = (Button) findViewById(R.id.intervbtn);

        screeningbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoryBuildingHome1.this, screening_main2.class);
                startActivity(intent);
            }
        });
        solutionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoryBuildingHome1.this, SolutionMethod_home.class);
                startActivity(intent);
            }
        });

    }
}
