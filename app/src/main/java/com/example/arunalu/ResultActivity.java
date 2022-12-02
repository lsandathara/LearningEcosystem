package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        long duration = getIntent().getLongExtra("duration",0);
        int score = getIntent().getIntExtra("score",0);

        DateFormat simple = new SimpleDateFormat("HH:mm:ss");
        Date result = new Date(duration);

        TextView correctCount = findViewById(R.id.tvCorrectCount);
        TextView time = findViewById(R.id.tvTime);

        correctCount.setText(score+"/100");
        time.setText(simple.format(result));
    }
}
