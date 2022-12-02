package com.example.arunalu;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Screening_env1 extends AppCompatActivity {

     TextView outputText;
    // private ImageView micbutton;
    Button showDialog1,acceptBtn;
    Dialog custom_dialog,failed_custom_dialog;



    private static final int REQUEST_RECORD_PERMISSION = 100;
    private Intent recognizerIntent;
    private SpeechRecognizer speech;
    private Intent recognizerIntent1;
    private SpeechRecognizer speech1;
    private Intent recognizerIntent2;
    private SpeechRecognizer speech2;
    String outputtextstring1 = null;
    String outputtextstring2 = null;
    String outputtextstring3  =null;
    TextView textviewTimer;

    public Chronometer countdownTimer;
    public long pauseOffset;
    public ArrayList<String> misspelledwords=new ArrayList<String>();
    public ArrayList<String> correctlyspelledwords=new ArrayList<String>();
    public float totPercentage;
    public String stringPercentage;
    public int correctword;

    public boolean timerRunning;

    String txt1 = "ඉර පායලා";
    String txt2 = "කුරුල්ලෝ ගී කියනවා";
    String txt3 = "සමනලයා පියාඹනවා";




    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening_env1);
        checkpermission();

        outputText = (TextView) findViewById(R.id.outputtxt);
        ImageView micbutton = (ImageView) findViewById(R.id.micBtn);
        ImageView micbutton2 = (ImageView) findViewById(R.id.micBtnbird);
        ImageView micbutton3 = (ImageView) findViewById(R.id.micBtnBtfly);



        custom_dialog = new Dialog(this);
        failed_custom_dialog = new Dialog(this);

        showDialog1 = (Button) findViewById(R.id.viewDialog1);
        //coundowntimer
        countdownTimer = (Chronometer) findViewById(R.id.time);

        showDialog1.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                StopTimer();
                //showDialogPopup(view);
                ValidationText(view);
            }
        });



        speech = SpeechRecognizer.createSpeechRecognizer(Screening_env1.this);
        speech1 = SpeechRecognizer.createSpeechRecognizer(Screening_env1.this);
        speech2  =SpeechRecognizer.createSpeechRecognizer(Screening_env1.this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "si-LK");

        recognizerIntent1 = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent1.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        recognizerIntent1.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "si-LK");

        recognizerIntent2 = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent2.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        recognizerIntent2.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "si-LK");


        speech1.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {

                ArrayList<String> matchesFound = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                if (matchesFound != null) {
                    outputtextstring2 = matchesFound.get(0);
                    outputText.setText(outputtextstring2);
                    Log.d("outputString2",outputtextstring2);

                }

            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });



        speech.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                ArrayList<String> matchesFound = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                if (matchesFound != null) {
                    outputtextstring1 = matchesFound.get(0);
                    outputText.setText(outputtextstring1);
                    Log.d("outputString1",outputtextstring1);


                }

            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

        speech2.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                ArrayList<String> matchesFound = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                if (matchesFound != null) {
                    outputtextstring3 = matchesFound.get(0);
                    outputText.setText(outputtextstring3);
                    Log.d("outputString3",outputtextstring3);


                }

            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });


        micbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startTimer();
                        speech.startListening(recognizerIntent);
                        outputtextstring1 = "";
                        break;
                    case MotionEvent.ACTION_UP:
                        speech.stopListening();
                        break;
                }
                return false;

            }
        });

        micbutton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        speech1.startListening(recognizerIntent1);
                        outputtextstring2 = "";
                       // StopTimer();
                        break;
                    case MotionEvent.ACTION_UP:
                        speech1.stopListening();
                        break;
                }

                return false;
            }
        });

        micbutton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        speech2.startListening(recognizerIntent2);
                        outputtextstring3 = "";
                        // StopTimer();
                        break;
                    case MotionEvent.ACTION_UP:
                        speech2.stopListening();
                        break;
                }

                return false;
            }
        });


    }


    public void ViewHelp(View view){

        Intent intent = new Intent(Screening_env1.this, HintActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right_hint,R.anim.slide_out_left);

    }



    public void startTimer(){
      if(!timerRunning){
          countdownTimer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
          countdownTimer.start();
          timerRunning = true;
      }

    }

    public void StopTimer(){
       if(timerRunning){
           countdownTimer.stop();
           pauseOffset = SystemClock.elapsedRealtime() - countdownTimer.getBase();
           timerRunning = false;
       }

    }




    //validating app content and speech-to-text output string
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void ValidationText(View view){
//        if(outputtextstring1.equals(txt1) && outputtextstring2.equals(txt2) && outputtextstring3.equals(txt3)){
//            showDialogPopup(view);
//
//        }

        String[] splited_outputstring1 = outputtextstring1.split("\\s+");
        String[] splited_text1 = txt1.split("\\s+");

        String[] splited_outputstring2 = outputtextstring2.split("\\s+");
        String[] splited_text2 = txt2.split("\\s+");

        String[] splited_outputstring3 = outputtextstring3.split("\\s+");
        String[] splited_text3 = txt3.split("\\s+");

        int a = splited_outputstring1.length;
        int b = splited_text1.length;

        int c = splited_outputstring2.length;
        int d = splited_text2.length;

        int e = splited_outputstring3.length;
        int f = splited_text3.length;



//        for(String wordmissspelled1 : splited_outputstring1){
//            if(!(Arrays.equals(splited_outputstring1,splited_text1))){
//                 misspelledwords.add(wordmissspelled1);
//            }
//        }
//        for(String wordmissspelled2 : splited_outputstring2){
//            if(!(Arrays.equals(splited_outputstring2,splited_text2))){
//                misspelledwords.add(wordmissspelled2);
//            }
//        }
//        for(String wordmissspelled3 : splited_outputstring3){
//            if(!(Arrays.equals(splited_outputstring3,splited_text3))){
//                misspelledwords.add(wordmissspelled3);
//            }
//        }

//        if(a == b && c == d && e == f){
            boolean retval1,retval2,retval3;


            retval1 = Arrays.equals(splited_outputstring1,splited_text1);
            retval2 = Arrays.equals(splited_outputstring2,splited_text2);
            retval3 = Arrays.equals(splited_outputstring3,splited_text3);


//checking miss-spelled words
        for(int i=0;i < splited_outputstring1.length;i++){
            if(!splited_text1[i].equals(splited_outputstring1[i])){
                misspelledwords.add(splited_text1[i]);
            }
            else{
                correctlyspelledwords.add(splited_text1[i]);

            }




        }

        for(int i=0;i < splited_outputstring2.length;i++){
            if(!splited_text2[i].equals(splited_outputstring2[i])){
                misspelledwords.add(splited_text2[i]);
            }
            else{
                correctlyspelledwords.add(splited_text2[i]);

            }



        }

        for(int i=0;i < splited_outputstring3.length;i++){
            if(!splited_text3[i].equals(splited_outputstring3[i])){
                misspelledwords.add(splited_text3[i]);
            }
            else{
                correctlyspelledwords.add(splited_text3[i]);

            }


        }


        totPercentage = ((float)correctlyspelledwords.size()/ (splited_text1.length + splited_text2.length + splited_text3.length)) * 100;

        BigDecimal bd = new BigDecimal(Float.toString(totPercentage));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        stringPercentage = Float.toString(bd.floatValue());



            if(retval1 && retval2 && retval3){
                showDialogPopup(view);
            }
            else{
                //Failed dialog popup view
                ShowFailedPopup(view);

            }
//        }

    }

    //success dialog popup
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void showDialogPopup(View view){

        ImageView txtclose;
        Button acceptBtn;
        TextView timetext;
        custom_dialog.setContentView(R.layout.popupdialog);
        txtclose =(ImageView) custom_dialog.findViewById(R.id.closePopup);
        acceptBtn = (Button) custom_dialog.findViewById(R.id.acceptBtn);
        timetext = (TextView) custom_dialog.findViewById(R.id.timeFromChronometer);


        @SuppressLint("DefaultLocale") String time_hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(pauseOffset),
                TimeUnit.MILLISECONDS.toMinutes(pauseOffset) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(pauseOffset)),
                TimeUnit.MILLISECONDS.toSeconds(pauseOffset) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(pauseOffset)));

        timetext.setText(time_hms);


        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_dialog.dismiss();
            }
        });
        Objects.requireNonNull(custom_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        custom_dialog.show();

        acceptBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Screening_env1.this, screening_main2.class);
                startActivity(intent);

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void ShowFailedPopup(View view){

        ImageView txtclose;
        Button acceptBtn;
        TextView timetext;
        TextView misspelled;
        TextView perc;

        failed_custom_dialog.setContentView(R.layout.failedpopup);
        txtclose =(ImageView) failed_custom_dialog.findViewById(R.id.closePopupf);
        acceptBtn = (Button) failed_custom_dialog.findViewById(R.id.acceptBtnf);
        misspelled = (TextView)  failed_custom_dialog.findViewById(R.id.misspelled);
        perc = (TextView)  failed_custom_dialog.findViewById(R.id.perc);


        timetext = (TextView) failed_custom_dialog.findViewById(R.id.timeFromChronometer);


        @SuppressLint("DefaultLocale") String time_hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(pauseOffset),
                TimeUnit.MILLISECONDS.toMinutes(pauseOffset) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(pauseOffset)),
                TimeUnit.MILLISECONDS.toSeconds(pauseOffset) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(pauseOffset)));

        timetext.setText(time_hms);
        misspelled.setText(misspelledwords.toString());
        perc.setText(stringPercentage + "%");


        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failed_custom_dialog.dismiss();
            }
        });
        Objects.requireNonNull(failed_custom_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        failed_custom_dialog.show();

        acceptBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Screening_env1.this, screening_main2.class);
                startActivity(intent);

            }
        });
    }

        private void checkpermission(){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(!(ContextCompat.checkSelfPermission(Screening_env1.this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)){
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                    startActivity(intent);
                    finish();
                }
            }
        }



}
