package com.example.arunalu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class ResultDialogVideoReading extends AppCompatDialogFragment {
    TextView timeText;
    TextView correctWordsum;
    TextView incorrectWordsum;
    TextView percentageWord;
    String className;
    Activity activity;

    @SuppressLint("ResourceType")
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_result_dialog_video_reading, null);

        //Set title for the dialog
        builder.setView(view)
                .setTitle("දරැවාගේ වචන උච්චාරනය");

        //get values from test activity
        final Bundle bundle = getArguments();
        className = bundle.getString("class", "");

        //add onClickListener to navigate for the second test when click yes
        view.findViewById(R.id.btn_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (className.equals("VideoBasedScreeningTest3")){
                    System.out.println("Test1");
                    Intent intent = new Intent(view.getContext(), VideoBasedScreeningTest2.class);
                    intent.putExtra("pronouncedWord",bundle.getStringArray("pronouncedWord"));
                    intent.putExtra("correctPronouncedWord",bundle.getStringArray("correctPronouncedWord"));
                    intent.putExtra("incorrectPronouncedWord",bundle.getStringArray("incorrectPronouncedWord"));
                    intent.putExtra("correctWord",bundle.getInt("correctWord"));
                    intent.putExtra("incorrectWord",bundle.getInt("incorrectWord"));
                    view.getContext().startActivity(intent);
                }else if (className.equals("VideoBasedScreeningTest2")){
                    System.out.println("Test3");
                    Intent intent = new Intent(getActivity(), VideoBasedScreeningTest1.class);
                    intent.putExtra("pronouncedWord",bundle.getStringArray("pronouncedWord"));
                    intent.putExtra("correctPronouncedWord",bundle.getStringArray("correctPronouncedWord"));
                    intent.putExtra("incorrectPronouncedWord",bundle.getStringArray("incorrectPronouncedWord"));
                    intent.putExtra("correctWord",bundle.getInt("correctWord"));
                    intent.putExtra("incorrectWord",bundle.getInt("incorrectWord"));
                    startActivity(intent);
                }else if (className.equals("VideoBasedScreeningTest3")){
                    System.out.println("Test2");
                    Intent intent = new Intent(getActivity(), levelReport.class);
                    intent.putExtra("pronouncedWord",bundle.getStringArray("pronouncedWord"));
                    intent.putExtra("correctPronouncedWord",bundle.getStringArray("correctPronouncedWord"));
                    intent.putExtra("incorrectPronouncedWord",bundle.getStringArray("incorrectPronouncedWord"));
                    intent.putExtra("correctWord",bundle.getInt("correctWord"));
                    intent.putExtra("incorrectWord",bundle.getInt("incorrectWord"));
                    intent.putExtra("time",bundle.getString("time", ""));
                    startActivity(intent);
                }

                if (className.equals("VideoBasedSolutionTest1")){
                    System.out.println("Test1");
                    Intent intent = new Intent(view.getContext(), VideoBasedSolutionTest2.class);
                    intent.putExtra("pronouncedWord",bundle.getStringArray("pronouncedWord"));
                    intent.putExtra("correctPronouncedWord",bundle.getStringArray("correctPronouncedWord"));
                    intent.putExtra("incorrectPronouncedWord",bundle.getStringArray("incorrectPronouncedWord"));
                    intent.putExtra("correctWord",bundle.getInt("correctWord"));
                    intent.putExtra("incorrectWord",bundle.getInt("incorrectWord"));
                    view.getContext().startActivity(intent);
                }else if (className.equals("VideoBasedSolutionTest2")){
                    System.out.println("Test3");
                    Intent intent = new Intent(getActivity(), VideoBasedSolutionTest3.class);
                    intent.putExtra("pronouncedWord",bundle.getStringArray("pronouncedWord"));
                    intent.putExtra("correctPronouncedWord",bundle.getStringArray("correctPronouncedWord"));
                    intent.putExtra("incorrectPronouncedWord",bundle.getStringArray("incorrectPronouncedWord"));
                    intent.putExtra("correctWord",bundle.getInt("correctWord"));
                    intent.putExtra("incorrectWord",bundle.getInt("incorrectWord"));
                    startActivity(intent);
                }else if (className.equals("VideoBasedSolutionTest3")){
                    System.out.println("Test2");
                    Intent intent = new Intent(getActivity(), levelReport.class);
                    intent.putExtra("pronouncedWord",bundle.getStringArray("pronouncedWord"));
                    intent.putExtra("correctPronouncedWord",bundle.getStringArray("correctPronouncedWord"));
                    intent.putExtra("incorrectPronouncedWord",bundle.getStringArray("incorrectPronouncedWord"));
                    intent.putExtra("correctWord",bundle.getInt("correctWord"));
                    intent.putExtra("incorrectWord",bundle.getInt("incorrectWord"));
                    intent.putExtra("time",bundle.getString("time", ""));
                    startActivity(intent);
                }

                if (className.equals("VideoBasedSolutionTest4")){
                    System.out.println("Test1");
                    Intent intent = new Intent(view.getContext(), VideoBasedSolutionTest6.class);
                    intent.putExtra("pronouncedWord",bundle.getStringArray("pronouncedWord"));
                    intent.putExtra("correctPronouncedWord",bundle.getStringArray("correctPronouncedWord"));
                    intent.putExtra("incorrectPronouncedWord",bundle.getStringArray("incorrectPronouncedWord"));
                    intent.putExtra("correctWord",bundle.getInt("correctWord"));
                    intent.putExtra("incorrectWord",bundle.getInt("incorrectWord"));
                    view.getContext().startActivity(intent);
                }else if (className.equals("VideoBasedSolutionTest6")){
                    System.out.println("Test3");
                    Intent intent = new Intent(getActivity(), VideoBasedSolutionTest3.class);
                    intent.putExtra("pronouncedWord",bundle.getStringArray("pronouncedWord"));
                    intent.putExtra("correctPronouncedWord",bundle.getStringArray("correctPronouncedWord"));
                    intent.putExtra("incorrectPronouncedWord",bundle.getStringArray("incorrectPronouncedWord"));
                    intent.putExtra("correctWord",bundle.getInt("correctWord"));
                    intent.putExtra("incorrectWord",bundle.getInt("incorrectWord"));
                    startActivity(intent);
                }else if (className.equals("VideoBasedSolutionTest6")){
                    System.out.println("Test2");
                    Intent intent = new Intent(getActivity(), levelReport.class);
                    intent.putExtra("pronouncedWord",bundle.getStringArray("pronouncedWord"));
                    intent.putExtra("correctPronouncedWord",bundle.getStringArray("correctPronouncedWord"));
                    intent.putExtra("incorrectPronouncedWord",bundle.getStringArray("incorrectPronouncedWord"));
                    intent.putExtra("correctWord",bundle.getInt("correctWord"));
                    intent.putExtra("incorrectWord",bundle.getInt("incorrectWord"));
                    intent.putExtra("time",bundle.getString("time", ""));
                    startActivity(intent);
                }
            }
        });

        //add onClickListener to dismiss the dialog when click no
        view.findViewById(R.id.btn_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        timeText = view.findViewById(R.id.txt_time_value);
        correctWordsum = view.findViewById(R.id.correct_word_val);
        incorrectWordsum = view.findViewById(R.id.incorrect_word_val);
        percentageWord = view.findViewById(R.id.percentage_val);
        int allWord = Integer.parseInt(bundle.getString("correctWord", "")) + Integer.parseInt(bundle.getString("incorrectWord", ""));
        //Assign each values into relevant text view
        correctWordsum.setText(bundle.getString("correctWord", "") + "/"+allWord);
        incorrectWordsum.setText(bundle.getString("incorrectWord", "") + "/"+allWord);
        percentageWord.setText(bundle.getString("percentage", "") + "%");
        timeText.setText(bundle.getString("time", ""));

        if (Integer.parseInt(bundle.getString("incorrectWord", "")) != 0){
            view.findViewById(R.id.gifImageView).setBackgroundResource(R.drawable.try_again);
        }else {
            view.findViewById(R.id.gifImageView).setBackgroundResource(R.drawable.ballon);
        }

        return builder.create();
    }
}
