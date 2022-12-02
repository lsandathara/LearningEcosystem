package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
    }

    public void LoadReadingEnv(View view){

        Intent intent = new Intent(HintActivity.this, Screening_env1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left_hint,R.anim.slide_out_right);

    }
}
