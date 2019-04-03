package com.sparkdev.foodapp.loginscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.mainscreen.TabLayoutActivity;
import com.sparkdev.foodapp.models.firebase.FirebaseAdapter;
import com.sparkdev.foodapp.models.firebase.loginInterface.LoginCompletionListener;
import com.sparkdev.foodapp.registerscreen.RegisterActivity;

public class Login extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button login;
    private static TextView register;
    private FirebaseAdapter firebase;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebase = FirebaseAdapter.getInstance(context);

        loginButton();

    }

    public void loginButton() {

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);



        login.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        if (username.getText().toString().equals("")) {
                            Toast.makeText(getApplicationContext(), "Enter a username!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (password.getText().toString().equals("")) {
                            Toast.makeText(getApplicationContext(), "Enter a password!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (password.getText().length() < 6) {
                            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            firebase.loginUser(username.getText().toString(), password.getText().toString(), new LoginCompletionListener() {
                                @Override
                                public void onSuccess() {

                                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplicationContext(), TabLayoutActivity.class);
                                    startActivity(i);
                                }

                                @Override
                                public void onFailure() {
                                    Toast.makeText(getApplicationContext(), "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }


                }
        );

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);

            }
        });

    }


}
