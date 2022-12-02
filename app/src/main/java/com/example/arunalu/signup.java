package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    DatabaseHelper db;
    EditText fnametext,emailtext,usernametext,pwtext,cpwtext;
    Button signupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db = new DatabaseHelper(this);

        fnametext = (EditText) findViewById(R.id.fname);
        emailtext = (EditText) findViewById(R.id.email2);
        usernametext = (EditText) findViewById(R.id.username);
        pwtext = (EditText) findViewById(R.id.password);
        cpwtext = (EditText) findViewById(R.id.passwordc);
        signupBtn = (Button) findViewById(R.id.signupBtn);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String fname = fnametext.getText().toString();
                String email = emailtext.getText().toString();
                String username = usernametext.getText().toString();
                String password = pwtext.getText().toString();
                String confirmpw = cpwtext.getText().toString();

                if(fname.equals("") || email.equals("") || username.equals("")||
                password.equals("") || confirmpw.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();

                }

                else{
                    if(password.equals(confirmpw)){
                        Boolean checkusername = db.checkUsernameAvailability(username);

                        if(checkusername == true){
                            Boolean add = db.addUser(username,password,fname,email);
                            if(add == true){
                                Toast.makeText(getApplicationContext(), "Registered Successfully!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Username Already Exists. Please login!", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
