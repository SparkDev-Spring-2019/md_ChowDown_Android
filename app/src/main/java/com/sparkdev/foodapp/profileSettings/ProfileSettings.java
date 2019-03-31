package com.sparkdev.foodapp.profileSettings;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.AdapterListUpdateCallback;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.User;

import java.util.ArrayList;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

/*
This class represents the ProfileSettingsActivity which will display all the row titles from an ArrayList
and validate user input
 */

public class ProfileSettings extends AppCompatActivity   {
    private RecyclerView profileRecyclerView;
    private ProfileSettingsAdapter profileAdapter;
    private ArrayList <String> row_titles = new ArrayList<>();
    private ArrayList <String> user_input = new ArrayList<>();
    //private User u = new User();
    private Toolbar myToolbar;
    private CircleImageView circleImageView;
    private Menu menuItem;
    private View view;
    private EditText editText;

    // The ProfileSettingsActivity enters the created state when the activity is created for the first
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

        //this.profileAdapter = new ProfileSettingsAdapter(this);

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        circleImageView.setImageResource(R.mipmap.g1321);

        menuItem = (Menu) findViewById(R.id.action_save);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*public void confirmInput(View v) {
        if (!validateEmail() | !validateUsername() | !validatePassword()) {
            return;
        }

        String input = "Email: " + textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + textInputUsername.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }*/


}
