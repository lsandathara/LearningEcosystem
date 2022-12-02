package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Locale;

public class VideoBasedSolutionTest3 extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private SpeechRecognizer speechRecognizer;
    private Intent speechRecognizerIntent;
    MediaPlayer player;

    String timeText;
    String className;
    int  correctWord = 0;
    int  incorrectWord = 0;
    float percentage;

    String actualSentence = "අහස පුරා පාට හතයි";
    String inputSentence;

    String pronouncedWord[];
    String correctPronouncedWord[];
    String incorrectPronouncedWord[];

    Bundle bundle = new Bundle();

    int  totalCorrectWord = 0;
    int  totalIncorrectWord = 0;

    int count = 0;
    long totalSeconds = 30;
    long intervalSeconds = 1;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_based_solution_test3);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            pronouncedWord= null;
        } else {
            pronouncedWord = extras.getStringArray("pronouncedWord");
            correctPronouncedWord = extras.getStringArray("correctPronouncedWord");
            incorrectPronouncedWord = extras.getStringArray("incorrectPronouncedWord");
            totalCorrectWord = extras.getInt("correctWord");
            totalIncorrectWord = extras.getInt("incorrectWord");
        }

        VideoView rainbowVideo = (VideoView)findViewById(R.id.rainbow_video);

        rainbowVideo.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rainbow_video));

        rainbowVideo.start();

        rainbowVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        relativeLayout = findViewById(R.id.relLayout3);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(VideoBasedSolutionTest3.this);
        speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "si-LK");

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
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
                ArrayList<String> matches = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                inputSentence = matches.get(0);
                if (matches != null){
                    inputSentence = matches.get(0);
                    timeText = "";
                    splitWords(inputSentence);
                    //Toast.makeText(VideoBasedScreeningTest1.this,"Result = "+inputSentence,Toast.LENGTH_LONG).show();
                    timer.cancel();
                    showDialog();
                    correctWord = 0;
                    incorrectWord = 0;
                }
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

        timer = new CountDownTimer(totalSeconds*1000, intervalSeconds*1000) {
            public void onTick(long millisUntilFinished) {
                timeText = (totalSeconds * 1000 - millisUntilFinished) / 1000 + ":" + millisUntilFinished % 1000;
                bundle.putString("time", timeText);
                System.out.println("TIMER : "+(totalSeconds * 1000 - millisUntilFinished) / 1000);
            }

            public void onFinish() {
                System.out.println("FINISHED");
            }
        };
        //get the voice when click the icon and stop the process after press the icon
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        timer.start();
                        speechRecognizer.startListening(speechRecognizerIntent);

                    case MotionEvent.ACTION_UP:
                        speechRecognizer.stopListening();
                        break;
                }

                return false;
            }
        });
    }

    //play the audio by using media player
    public void playGuidanceAudio(){
        if (player == null){
            player = MediaPlayer.create(this,R.raw.guidance1);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    //Stop the audio when exit from the application
    private void stopPlayer(){
        if (player != null){
            player.release();
            player = null;
        }
    }

    //stop the audio which given guidance
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

    //get voice from the microphone
    private void getVoiceInput(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (!(ContextCompat.checkSelfPermission(VideoBasedSolutionTest3.this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)){
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                finish();
            }
        }
    }

    //Display fragment Dialog and set values into fields
    public void showDialog(){
        ResultDialogVideoReading dialog = new ResultDialogVideoReading();

        bundle.putString("correctWord", String.valueOf(correctWord));
        bundle.putString("incorrectWord", String.valueOf(incorrectWord));
        bundle.putString("percentage", String.valueOf(percentage));
        //bundle.putString("time", timeText);
        className = "VideoBasedSolutionTest3";
        bundle.putString("class", className);

        bundle.putStringArray("pronouncedWord",pronouncedWord);
        bundle.putStringArray("correctPronouncedWord",correctPronouncedWord);
        bundle.putStringArray("incorrectPronouncedWord",incorrectPronouncedWord);

        dialog.setArguments(bundle);
        dialog.show(getSupportFragmentManager(), "Result Dialog");
    }

    public void splitWords(String inputSentence){
        String[] splitActualString = actualSentence.split("\\s+");
        String[] splitInputString = inputSentence.split("\\s+");

        int j=correctPronouncedWord.length;
        int k=pronouncedWord.length-1;
        int r = incorrectPronouncedWord.length;

        int length = splitInputString.length + correctPronouncedWord.length;
        correctPronouncedWord = new String[length];
        pronouncedWord = new String[length];
        incorrectPronouncedWord = new String[length];

        for (int i=0;i<splitInputString.length;i++){
            if (splitActualString[i].equals(splitInputString[i])){
                correctWord += 1;
                totalCorrectWord += correctWord;
                correctPronouncedWord[j] = splitActualString[i];
                j++;
            }else {
                incorrectWord += 1;
                totalIncorrectWord += incorrectWord;
                pronouncedWord[k] = splitInputString[i];
                incorrectPronouncedWord[r] = splitActualString[i];
                k++;
                r++;
            }
        }

        percentage = ((float) correctWord/splitActualString.length)*100;
        System.out.println("correct : "+ correctWord);
        System.out.println("length : "+ splitActualString.length);
        System.out.println("PERCENTAGE : "+ percentage);
    }
}
