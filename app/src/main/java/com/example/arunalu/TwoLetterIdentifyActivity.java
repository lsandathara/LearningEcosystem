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

public class TwoLetterIdentifyActivity extends AppCompatActivity {

    ImageView imgRata, imgDestRata, imgKata, imgDestKata, imgMala, imgDestMala, imgDara, imgDestDara, imgGasa, imgDestGasa;

    Date startTime;
    int REQUEST_CODE = 10005;
    int score = 0;
    String nextSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_letter_identify);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        startTime = Calendar.getInstance().getTime();

        imgDestDara = findViewById(R.id.imgDestDara);
        imgDara = findViewById(R.id.imgDara);
        imgDestGasa = findViewById(R.id.imgDestGasa);
        imgGasa = findViewById(R.id.imgGasa);
        imgDestKata = findViewById(R.id.imgDestKata);
        imgKata = findViewById(R.id.imgKata);
        imgDestRata = findViewById(R.id.imgDestRata);
        imgRata = findViewById(R.id.imgRata);
        imgDestMala = findViewById(R.id.imgDestMala);
        imgMala = findViewById(R.id.imgMala);


        imgDestDara.setOnDragListener(dragListener);
        imgDestGasa.setOnDragListener(dragListener);
        imgDestKata.setOnDragListener(dragListener);
        imgDestRata.setOnDragListener(dragListener);
        imgDestMala.setOnDragListener(dragListener);

        imgDara.setOnLongClickListener(longClickListener);
    }

    private void dropAction(View view, View v) {
        if(view.getId()==R.id.imgDara && v.getId()==R.id.imgDestDara)
        {
            performChanges(imgDestDara,imgDara,"Gasa");
        }
        else if(view.getId()==R.id.imgGasa && v.getId()==R.id.imgDestGasa)
        {
            performChanges(imgDestGasa,imgGasa,"Kata");
        }
        else if(view.getId()==R.id.imgKata && v.getId()==R.id.imgDestKata)
        {
            performChanges(imgDestKata,imgKata,"Rata");
        }
        else if(view.getId()==R.id.imgRata && v.getId()==R.id.imgDestRata)
        {
            performChanges(imgDestRata,imgRata,"Mala");
        }
        else if(view.getId()==R.id.imgMala && v.getId()==R.id.imgDestMala)
        {
            performChanges(imgDestMala,imgMala,"Done");
        }

    }

    private void performChanges(ImageView destImage, ImageView img, String nextStr) {
        nextSt = nextStr;
        destImage.setColorFilter( 0xffff0000, PorterDuff.Mode.SRC_ATOP );
        img.setVisibility(View.GONE);
        Intent intent = new Intent(TwoLetterIdentifyActivity.this, CorrectDialogActivity.class);
        if(nextStr.equals("Gasa"))
        {
            intent.putExtra("letter","Dara");
            imgGasa.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Kata"))
        {
            intent.putExtra("letter","Gasa");
            imgKata.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Rata"))
        {
            intent.putExtra("letter","Kata");
            imgRata.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Mala"))
        {
            intent.putExtra("letter","Rata");
            imgMala.setOnLongClickListener(longClickListener);
        }
        else if(nextStr.equals("Done"))
        {
            intent.putExtra("letter","Mala");
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
                    score = score + 20;
                    // Log.d("SCORE", "onActivityResult: " + score);
                }

                if(nextSt.equals("Done"))
                {
                    Intent intent = new Intent(TwoLetterIdentifyActivity.this,ResultActivity.class);
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
