package com.example.arunalu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class LetterIdentifyActivity extends AppCompatActivity {

    ImageView imgRa, imgDestRa, imgTa, imgDestTa, imgLa, imgDestLa, imgSa, imgDestSa, imgKa, imgDestKa;
    ImageView imgGa, imgDestGa, imgVa, imgDestVa, imgDa, imgDestDa, imgMa, imgDestMa, imgNa, imgDestNa;

    Date startTime;
    int REQUEST_CODE = 10005;
    int score = 0;
    String nextSt;

    Boolean identifyMode = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_identify);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        if(getIntent().getStringExtra("mode").equals("identify"))
        {
            identifyMode = true;
        }

        startTime = Calendar.getInstance().getTime();

        imgDestRa = findViewById(R.id.imgDestRa);
        imgRa = findViewById(R.id.imgRa);
        imgDestTa = findViewById(R.id.imgDestTa);
        imgTa = findViewById(R.id.imgTa);
        imgDestLa = findViewById(R.id.imgDestLa);
        imgLa = findViewById(R.id.imgLa);
        imgDestSa = findViewById(R.id.imgDestSa);
        imgSa = findViewById(R.id.imgSa);
        imgDestKa = findViewById(R.id.imgDestKa);
        imgKa = findViewById(R.id.imgKa);
        imgDestGa = findViewById(R.id.imgDestGa);
        imgGa = findViewById(R.id.imgGa);
        imgDestVa = findViewById(R.id.imgDestVa);
        imgVa = findViewById(R.id.imgVa);
        imgDestDa = findViewById(R.id.imgDestDa);
        imgDa = findViewById(R.id.imgDa);
        imgDestMa = findViewById(R.id.imgDestMa);
        imgMa = findViewById(R.id.imgMa);
        imgDestNa = findViewById(R.id.imgDestNa);
        imgNa = findViewById(R.id.imgNa);

        imgDestRa.setOnDragListener(dragListener);
        imgDestTa.setOnDragListener(dragListener);
        imgDestLa.setOnDragListener(dragListener);
        imgDestSa.setOnDragListener(dragListener);
        imgDestKa.setOnDragListener(dragListener);
        imgDestGa.setOnDragListener(dragListener);
        imgDestVa.setOnDragListener(dragListener);
        imgDestDa.setOnDragListener(dragListener);
        imgDestMa.setOnDragListener(dragListener);
        imgDestNa.setOnDragListener(dragListener);

        imgRa.setOnLongClickListener(longClickListener);
    }

    private void dropAction(View view, View v) {
        if(view.getId()==R.id.imgRa && v.getId()==R.id.imgDestRa)
        {
            performChanges(imgDestRa,imgRa,"Ta");
        }
        else if(view.getId()==R.id.imgTa && v.getId()==R.id.imgDestTa)
        {
            performChanges(imgDestTa,imgTa,"La");
        }
        else if(view.getId()==R.id.imgLa && v.getId()==R.id.imgDestLa)
        {
            performChanges(imgDestLa,imgLa,"Sa");
        }
        else if(view.getId()==R.id.imgSa && v.getId()==R.id.imgDestSa)
        {
            performChanges(imgDestSa,imgSa,"Ka");
        }
        else if(view.getId()==R.id.imgKa && v.getId()==R.id.imgDestKa)
        {
            performChanges(imgDestKa,imgKa,"Ga");
        }
        else if(view.getId()==R.id.imgGa && v.getId()==R.id.imgDestGa)
        {
            performChanges(imgDestGa,imgGa,"Va");
        }
        else if(view.getId()==R.id.imgVa && v.getId()==R.id.imgDestVa)
        {
            performChanges(imgDestVa,imgVa,"Da");
        }
        else if(view.getId()==R.id.imgDa && v.getId()==R.id.imgDestDa)
        {
            performChanges(imgDestDa,imgDa,"Ma");
        }
        else if(view.getId()==R.id.imgMa && v.getId()==R.id.imgDestMa)
        {
            performChanges(imgDestMa,imgMa,"Na");
        }
        else if(view.getId()==R.id.imgNa && v.getId()==R.id.imgDestNa)
        {
            performChanges(imgDestNa,imgNa,"Done");
        }
    }

    private void performChanges(ImageView destImage, ImageView img, String nextStr) {
        nextSt = nextStr;
        destImage.setColorFilter( 0xffff0000, PorterDuff.Mode.SRC_ATOP );
        img.setVisibility(View.GONE);
        Intent intent = new Intent(LetterIdentifyActivity.this, CorrectDialogActivity.class);

        if(identifyMode)
        {
            intent.putExtra("mode","identify");
        }

        if(nextStr.equals("Ta"))
        {
            intent.putExtra("letter","Ra");
            imgTa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("La"))
        {
            intent.putExtra("letter","Ta");
            imgLa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Sa"))
        {
            intent.putExtra("letter","La");
            imgSa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Ka"))
        {
            intent.putExtra("letter","Sa");
            imgKa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Ga"))
        {
            intent.putExtra("letter","Ka");
            imgGa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Va"))
        {
            intent.putExtra("letter","Ga");
            imgVa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Da"))
        {
            intent.putExtra("letter","Va");
            imgDa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Ma"))
        {
            intent.putExtra("letter","Da");
            imgMa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Na"))
        {
            intent.putExtra("letter","Ma");
            imgNa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Done"))
        {
            intent.putExtra("letter","Na");
        }
        startActivityForResult(intent,REQUEST_CODE);
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDragAndDrop(data,shadowBuilder,v,0);
            return  true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View)event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    dropAction(view,v);
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE  && resultCode  == RESULT_OK) {
                if(data != null) {
                    String ret = data.getStringExtra("MESSAGE");
                    Toast.makeText(this, ret, Toast.LENGTH_SHORT).show();
                    if(ret.equals("Correct"))
                    {
                        score = score + 10;
                       // Log.d("SCORE", "onActivityResult: " + score);
                    }

                    if(nextSt.equals("Done"))
                    {
                        Intent intent = new Intent(LetterIdentifyActivity.this,ResultActivity.class);
                        intent.putExtra("score",score);

                        if(identifyMode)
                        {
                            intent.putExtra("score",score);
                            String message = null;
                            if(score <= 30)
                            {
                                message = "Dyslexia වැඩි අවධානමක් ඇත.";
                            }
                            else
                            {
                                message = "Dyslexia වැඩි අවධානමක් ඇත.";
                            }
                        }

                        Date endTime = Calendar.getInstance().getTime();
                        long duration = endTime.getTime() - startTime.getTime();
                        intent.putExtra("duration",duration);
                        startActivity(intent);
                    }
                }
            }
    }
}
