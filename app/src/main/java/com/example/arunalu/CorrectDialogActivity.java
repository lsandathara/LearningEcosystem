package com.example.arunalu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CorrectDialogActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000 ;

    ImageView imgVoice;
    Button btnListen, btnSpeak,btnCorrect,btnTryAgain,btnSkip;
    String letter,letterSin;
    LinearLayout llTwoBtn,llCorrect,llWrong;
    TextView tv1,tvTitle;
    int listenId;
    Boolean identifyMode = false;
    int tryCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_dialog);

        try {
            int resourceId = R.raw.hapana;
            MediaPlayer mediaplayer = MediaPlayer.create(CorrectDialogActivity.this, resourceId);
            mediaplayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(getIntent().getStringExtra("mode").equals("identify"))
        {
            identifyMode = true;
        }

        letter = getIntent().getStringExtra("letter");
        imgVoice = findViewById(R.id.imgVoice);

        btnSpeak = findViewById(R.id.btnSpeak);
        btnListen = findViewById(R.id.btnListen);
        btnCorrect = findViewById(R.id.btnCorrect);
        btnTryAgain = findViewById(R.id.btnTryAgain);
        btnSkip = findViewById(R.id.btnSkip);

        llTwoBtn = findViewById(R.id.llTwoBtn);
        llCorrect = findViewById(R.id.llCorrect);
        llWrong = findViewById(R.id.llWrong);
        tv1 = findViewById(R.id.tv1);
        tvTitle = findViewById(R.id.tvTitle);

        btnCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("MESSAGE","Correct");
                setResult(RESULT_OK,intent);
                finish();//finishing activity
            }
        });

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llCorrect.setVisibility(View.GONE);
                llTwoBtn.setVisibility(View.VISIBLE);
                llWrong.setVisibility(View.GONE);
                tv1.setVisibility(View.VISIBLE);
                tvTitle.setText("ළමයා හපනා");
                changeLetter();
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("MESSAGE","Skip");
                setResult(RESULT_OK,intent);
                finish();//finishing activity
            }
        });

        changeLetter();

        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    MediaPlayer mediaplayer = MediaPlayer.create(CorrectDialogActivity.this, listenId);
                    mediaplayer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recognize();
            }
        });
    }

    private void changeLetter() {
        if(letter.equals("Ra"))
        {
            imgVoice.setImageResource(R.drawable.ra);
            letterSin = "ර";

            listenId = R.raw.ra;
        }
        else if (letter.equals("Ta"))
        {
            imgVoice.setImageResource(R.drawable.ta);
            letterSin = "ට";
            listenId = R.raw.ta;
        }
        else if(letter.equals("La"))
        {
            imgVoice.setImageResource(R.drawable.la);
            letterSin = "ල";
            listenId = R.raw.la;
        }
        else if(letter.equals("Sa"))
        {
            imgVoice.setImageResource(R.drawable.sa);
            letterSin = "ස";
            listenId = R.raw.sa;
        }
        else if(letter.equals("Ka"))
        {
            imgVoice.setImageResource(R.drawable.ka);
            letterSin = "ක";
            listenId = R.raw.ka;
        }
        else if(letter.equals("Ga"))
        {
            imgVoice.setImageResource(R.drawable.ga);
            letterSin = "ග";
            listenId = R.raw.ga;
        }
        else if(letter.equals("Va"))
        {
            imgVoice.setImageResource(R.drawable.va);
            letterSin = "ව";
            listenId = R.raw.va;
        }
        else if(letter.equals("Da"))
        {
            imgVoice.setImageResource(R.drawable.da);
            letterSin = "ද";
            listenId = R.raw.da;
        }
        else if(letter.equals("Ma"))
        {
            imgVoice.setImageResource(R.drawable.ma);
            letterSin = "ම";
            listenId = R.raw.ma;
        }
        else if(letter.equals("Na"))
        {
            imgVoice.setImageResource(R.drawable.na);
            letterSin = "න";
            listenId = R.raw.na;
        }
        else if(letter.equals("Dara"))
        {
            imgVoice.setImageResource(R.drawable.dara);
            letterSin = "දර";
            listenId = R.raw.dara;
        }
        else if(letter.equals("Gasa"))
        {
            imgVoice.setImageResource(R.drawable.gasa);
            letterSin = "ගස";
            listenId = R.raw.gasa;
        }
        else if(letter.equals("Mala"))
        {
            imgVoice.setImageResource(R.drawable.mala);
            letterSin = "මල";
            listenId = R.raw.mala;
        }
        else if(letter.equals("Rata"))
        {
            imgVoice.setImageResource(R.drawable.rata);
            letterSin = "රට";
            listenId = R.raw.rata;
        }
        else if(letter.equals("Kata"))
        {
            imgVoice.setImageResource(R.drawable.kata);
            letterSin = "කට";
            listenId = R.raw.kata;
        }
        else if(letter.equals("Amma"))
        {
            imgVoice.setImageResource(R.drawable.amma);
            letterSin = "අම්මා";
            listenId = R.raw.amma;
        }
        else if(letter.equals("Akka"))
        {
            imgVoice.setImageResource(R.drawable.akka);
            letterSin = "අක්කා";
            listenId = R.raw.akka;
        }
        else if(letter.equals("Tharava"))
        {
            imgVoice.setImageResource(R.drawable.tharava);
            letterSin = "තාරාවා";
            listenId = R.raw.tharava;
        }
        else if(letter.equals("Malla"))
        {
            imgVoice.setImageResource(R.drawable.malla);
            letterSin = "මල්ල ";
            listenId = R.raw.malla;
        }
    }

    private void recognize() {
        if(identifyMode)
        {
            tryCount++;
        }
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"si-LK");
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, CorrectDialogActivity.this.getPackageName());
        intent.putExtra("android.speech.extra.EXTRA_ADDITIONAL_LANGUAGES", new String[]{});
        //  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "කථනය ආරම්භ කරන්න....");


        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        }catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == RESULT_OK && data != null)
        {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            Toast.makeText(this, result.get(0), Toast.LENGTH_SHORT).show();
            checkResult(result.get(0));
        }
    }

    private void checkResult(String message) {
        if(message.equals(letterSin))
        {
            try {
                int resourceId = R.raw.correct;
                MediaPlayer mediaplayer = MediaPlayer.create(CorrectDialogActivity.this, resourceId);
                mediaplayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            imgVoice.setImageResource(R.drawable.correct);
            llCorrect.setVisibility(View.VISIBLE);
            llTwoBtn.setVisibility(View.GONE);
            llWrong.setVisibility(View.GONE);
            tv1.setVisibility(View.GONE);
        }
        else
        {
            try {
                int resourceId = R.raw.wrong;
                MediaPlayer mediaplayer = MediaPlayer.create(CorrectDialogActivity.this, resourceId);
                mediaplayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

            imgVoice.setImageResource(R.drawable.wong);
            llCorrect.setVisibility(View.GONE);
            llTwoBtn.setVisibility(View.GONE);
            llWrong.setVisibility(View.VISIBLE);
            tv1.setVisibility(View.GONE);
            tvTitle.setText("වැරදි අකුර");

            if(identifyMode && tryCount==3)
            {
                Intent intent=new Intent();
                intent.putExtra("MESSAGE","Wrong");
                setResult(RESULT_OK,intent);
                finish();//finishing activity
            }
            else if (identifyMode)
            {
                btnSkip.setVisibility(View.GONE);
            }
        }
    }
}
