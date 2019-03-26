package com.sparkdev.foodapp.profileSettings;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.sparkdev.foodapp.R;

import java.util.ArrayList;
import java.util.regex.Pattern;

/*
This class represents the ProfileSettingsActivity which will display all the row titles from an ArrayList.
 */

public class ProfileSettings extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 6 characters
                    "$");
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;
    private RecyclerView profileRecyclerView;
    private ProfileSettingsAdapter profileAdapter;
    private ArrayList <String> row_titles = new ArrayList<>();
    private Toolbar myToolbar;

    // The ContactListActivity enters the created state when the activity is created for the first
    // time (i.e. when the user opens the application).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        //textInputEmail = findViewById(R.id.text_input_email);
        //textInputUsername = findViewById(R.id.text_input_username);
        //textInputPassword = findViewById(R.id.text_input_password);

        // Add row titles
        row_titles.add("First Name");
        row_titles.add("Last Name");
        row_titles.add("Username");
        row_titles.add("Email");
        row_titles.add("Password");

        // Get access to the RecyclerView
        profileRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)
        profileAdapter = new ProfileSettingsAdapter(this,row_titles);
        // Connect the adapter to the RecyclerView
        profileRecyclerView.setAdapter(profileAdapter);
        // Define the RecyclerView's default layout manager
        profileRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if(emailInput.isEmpty()) {
            textInputEmail.setError("Field cannot be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        String usernameInput = textInputUsername.getEditText().getText().toString().trim();

        if(usernameInput.isEmpty()) {
            textInputUsername.setError("Field cannot be empty");
            return false;
        } else if (usernameInput.length() > 15){
            textInputUsername.setError("Username too long");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }

    }

    private boolean validatePassword() {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if(passwordInput.isEmpty()) {
            textInputPassword.setError("Field cannot be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputPassword.setError("Password too weak");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }
}
