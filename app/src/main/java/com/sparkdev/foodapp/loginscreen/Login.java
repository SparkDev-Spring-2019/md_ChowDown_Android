package com.sparkdev.foodapp.loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.registerscreen.RegisterActivity;

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

    public void loginButton() {

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);

        //registerButton();

        login.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if (username.getText().toString().equals("user") && password.getText().equals("pass")) {

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

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Login.this, RegisterActivity.class));
                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Yaga Yeet Skurt My bones hurt", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void registerButton(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Login.this, RegisterActivity.class));
                Toast.makeText(getApplicationContext(), "Yaga Yeet Skurt My bones hurt", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
