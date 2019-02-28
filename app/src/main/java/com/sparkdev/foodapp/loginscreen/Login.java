package com.sparkdev.foodapp.loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;

import com.sparkdev.foodapp.R;

public class Login extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button login;
    private static TextView register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton();
    }

    public void loginButton(){

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        register =  (TextView) findViewById(R.id.register);

        login.setOnClickListener(
               new View.OnClickListener(){
                    public void onClick(View v){
                        if(username.getText().toString().equals("user") && password.getText().equals("pass")){

                        }
                        if (username.getText().toString().equals("")) {
                            Toast.makeText(getApplicationContext(), "Enter a username!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (password.getText().toString().equals("")) {
                            Toast.makeText(getApplicationContext(), "Enter a password!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (password.length() <= 6) {
                            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }



               }
        );

        
    }
}
