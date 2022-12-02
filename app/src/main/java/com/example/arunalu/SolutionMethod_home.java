package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SolutionMethod_home extends AppCompatActivity {

    Button twothreeletters,mixletters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_method_home);

        mixletters = (Button) findViewById(R.id.mixletters);
        twothreeletters = (Button) findViewById(R.id.twothreeletters);

        mixletters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SolutionMethod_home.this, MixLettersReadingEnvActivity.class);
                startActivity(intent);
            }
        });


        twothreeletters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SolutionMethod_home.this, TwoThreeLetterReadingEnvActivity.class);
                startActivity(intent);
            }
        });
    }
}
