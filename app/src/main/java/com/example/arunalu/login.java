package com.example.arunalu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.Spannable.*;

public class login extends AppCompatActivity {

    EditText usernametext,passwordtext;
    Button loginb;
    TextView signupb;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        usernametext = (EditText) findViewById(R.id.username);
        passwordtext = (EditText) findViewById(R.id.password);
        loginb = (Button) findViewById(R.id.login);
        signupb = (TextView) findViewById(R.id.signuplink);

        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernametext.getText().toString();
                String password = passwordtext.getText().toString();

                Boolean credentialsCheck = db.authenticate(username,password);
                if(credentialsCheck){
                    Toast.makeText(getApplicationContext(), "Successful Login!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    intent.putExtra("username", usernametext.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Incorrect Login. Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });
    }


}
