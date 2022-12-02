package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TwoThreeLetterReadingEnvActivity extends AppCompatActivity {

    Button nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twothree_letter_reading_env);

        nextbtn = (Button) findViewById(R.id.nextBtn);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoThreeLetterReadingEnvActivity.this, TwoThreeLetterInterventionActivity.class);
                startActivity(intent);
            }
        });
    }
}
