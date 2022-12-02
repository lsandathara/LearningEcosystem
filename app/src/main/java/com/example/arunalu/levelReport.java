package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class levelReport extends AppCompatActivity {

    String pronouncedWord[];
    String correctPronouncedWord[];
    String incorrectPronouncedWord[];
    String timeText;

    int  totalCorrectWord = 0;
    int  totalIncorrectWord = 0;

    TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_report);

        timeView = findViewById(R.id.averageTimeVal);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            pronouncedWord= null;
        } else {
            pronouncedWord = extras.getStringArray("pronouncedWord");
            correctPronouncedWord = extras.getStringArray("correctPronouncedWord");
            incorrectPronouncedWord = extras.getStringArray("incorrectPronouncedWord");
            totalCorrectWord = extras.getInt("correctWord");
            totalIncorrectWord = extras.getInt("incorrectWord");
            timeText = extras.getString("time");
        }

//        timeView.setText(timeText);

        for (int i=0;i<pronouncedWord.length;i++){
            System.out.println("pronouncedWord"+pronouncedWord[i]);
        }

        for (int i=0;i<correctPronouncedWord.length;i++){
            System.out.println("correctPronouncedWord"+correctPronouncedWord[i]);
        }

        for (int i=0;i<incorrectPronouncedWord.length;i++){
            System.out.println("incorrectPronouncedWord"+incorrectPronouncedWord[i]);
        }
        System.out.println("totalCorrectWord"+totalCorrectWord);
        System.out.println("totalIncorrectWord"+totalIncorrectWord);
    }
}
