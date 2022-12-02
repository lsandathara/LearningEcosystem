package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    ImageView btn_letter,btn_two_letter,btn_three_letter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_letter = findViewById(R.id.btn_letter_play);
        btn_two_letter = findViewById(R.id.btn_two_letter_play);
        btn_three_letter = findViewById(R.id.btn_three_letter_play);

        btn_letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,LetterIdentifyActivity.class);
                startActivity(intent);
            }
        });

        btn_two_letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,TwoLetterIdentifyActivity.class);
                startActivity(intent);
            }
        });

        btn_three_letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,ThreeLetterIdentifyAtivity.class);
                startActivity(intent);
            }
        });
    }
}
