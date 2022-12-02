package com.example.arunalu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.Date;

public class ThreeLetterIdentifyAtivity extends AppCompatActivity {

    ImageView imgMalla, imgDestMalla, imgAkka, imgDestAkka, imgAmma, imgDestAmma, imgTharava, imgDestTharava;

    Date startTime;
    int REQUEST_CODE = 10005;
    int score = 0;
    String nextSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_letter_identify_ativity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        startTime = Calendar.getInstance().getTime();

        imgDestTharava = findViewById(R.id.imgDestTharava);
        imgTharava = findViewById(R.id.imgTharava);
        imgDestMalla = findViewById(R.id.imgDestMalla);
        imgMalla = findViewById(R.id.imgMalla);
        imgDestAkka = findViewById(R.id.imgDestAkka);
        imgAkka = findViewById(R.id.imgAkka);
        imgDestAmma = findViewById(R.id.imgDestAmma);
        imgAmma = findViewById(R.id.imgAmma);

        imgDestTharava.setOnDragListener(dragListener);
        imgDestMalla.setOnDragListener(dragListener);
        imgDestAkka.setOnDragListener(dragListener);
        imgDestAmma.setOnDragListener(dragListener);

        imgMalla.setOnLongClickListener(longClickListener);
    }

    private void dropAction(View view, View v) {
        if(view.getId()==R.id.imgMalla && v.getId()==R.id.imgDestMalla)
        {
            performChanges(imgDestMalla, imgMalla,"Akka");
        }
        else if(view.getId()==R.id.imgAkka && v.getId()==R.id.imgDestAkka)
        {
            performChanges(imgDestAkka,imgAkka,"Tharava");
        }
        else if(view.getId()==R.id.imgTharava && v.getId()==R.id.imgDestTharava)
        {
            performChanges(imgDestTharava,imgTharava,"Amma");
        }
        else if(view.getId()==R.id.imgAmma && v.getId()==R.id.imgDestAmma)
        {
            performChanges(imgDestAmma,imgAmma,"Done");
        }
    }

    private void performChanges(ImageView destImage, ImageView img, String nextStr) {
        nextSt = nextStr;
        destImage.setColorFilter( 0xffff0000, PorterDuff.Mode.SRC_ATOP );
        img.setVisibility(View.GONE);
        Intent intent = new Intent(ThreeLetterIdentifyAtivity.this, CorrectDialogActivity.class);
        if(nextStr.equals("Akka"))
        {
            intent.putExtra("letter","Malla");
            imgAkka.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Tharava"))
        {
            intent.putExtra("letter","Akka");
            imgTharava.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Amma"))
        {
            intent.putExtra("letter","Tharava");
            imgAmma.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Done"))
        {
            intent.putExtra("letter","Amma");
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
                if(ret.equals("Correct"))
                {
                    score = score + 25;
                    // Log.d("SCORE", "onActivityResult: " + score);
                }

                if(nextSt.equals("Done"))
                {
                    Intent intent = new Intent(ThreeLetterIdentifyAtivity.this,ResultActivity.class);
                    intent.putExtra("score",score);
                    Date endTime = Calendar.getInstance().getTime();
                    long duration = endTime.getTime() - startTime.getTime();
                    intent.putExtra("duration",duration);
                    startActivity(intent);
                }
            }
        }
    }
}
