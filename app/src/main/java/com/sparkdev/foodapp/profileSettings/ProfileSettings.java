package com.sparkdev.foodapp.profileSettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.User;
import com.sparkdev.foodapp.models.firebase.FirebaseAdapter;

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
    //FirebaseAdapter fb = FirebaseAdapter.getInstance(this);

    private Toolbar myToolbar;
    private CircleImageView circleImageView;
    private MenuItem menuItem;
    private View view;
    private EditText editText;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    ".{6,}" +               //at least 6 characters
                    "$");

    // The ProfileSettingsActivity enters the created state when the activity is created for the first
    // time (i.e. when the user opens the application).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        // Add row titles
        row_titles.add("First Name");
        row_titles.add("Last Name");
        row_titles.add("Address");
        row_titles.add("Email");
        row_titles.add("Password");

        User u = User.currentUser;

        // add user input
        if (u.getFirstName() != null)
        {
            user_input.add(u.getFirstName());
        }
        else
        {
            user_input.add("");
        }

        if (u.getLastName() != null)
        {
            user_input.add(u.getLastName());
        }
        else
        {
            user_input.add("");
        }

        if (u.getAddress() != null)
        {
            user_input.add(u.getAddress());
        }
        else
        {
            user_input.add("");
        }

        if (u.getEmail() != null)
        {
            user_input.add(u.getEmail());
        }
        else
        {
            user_input.add("");
        }

        if (u.getPassword() != null)
        {
            user_input.add(u.getPassword());
        }
        else
        {
            user_input.add("");
        }

        // Get access to the RecyclerView
        profileRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)
        profileAdapter = new ProfileSettingsAdapter(this,row_titles, user_input);
        // Connect the adapter to the RecyclerView
        profileRecyclerView.setAdapter(profileAdapter);
        // Define the RecyclerView's default layout manager
        profileRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //smooth scrolling
        profileRecyclerView.setNestedScrollingEnabled(false);

        //this.profileAdapter = new ProfileSettingsAdapter(this);

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        circleImageView.setImageResource(R.mipmap.g1321);

        menuItem = (MenuItem) findViewById(R.id.action_save);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(R.id.action_save == item.getItemId())
        {
            if(profileAdapter.getIsAllValidated())
            {
                //fb.updateProfile();
                Toast.makeText(this, "Changes saved!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Information incorrect or missing!", Toast.LENGTH_SHORT).show();
            }
            //do something
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static boolean validateFirstName(EditText editText)
    {
        String firstNameInput = editText.getText().toString().trim();

        if (firstNameInput.isEmpty() || firstNameInput.length() == 0) {
            editText.setError("Field cannot be empty");
            return false;
        } else if (!firstNameInput.matches("[a-zA-Z]*")) {
            editText.setError("Field can only contain letters");
            return false;
        } else {
            editText.setError(null);
            return true;
        }
    }

    public static boolean validateLastName(EditText editText)
    {
        String lastNameInput = editText.getText().toString().trim();

        if (lastNameInput.isEmpty() || lastNameInput.length() == 0) {
            editText.setError("Field cannot be empty");
            return false;
        } else if (!lastNameInput.matches("[a-zA-Z]*")) {
            editText.setError("Field can only contain letters");
            return false;
        } else {
            editText.setError(null);
            return true;
        }
    }

    public static boolean validateAddress(EditText editText)
    {
        String addressInput = editText.getText().toString().trim();

        if(addressInput.isEmpty() || addressInput.length() == 0) {
            editText.setError("Field cannot be empty");
            return false;
        } else {
            editText.setError(null);
            return true;
        }
    }


    public static boolean validateEmail(EditText editText)
    {
        String emailInput = editText.getText().toString().trim();

        if(emailInput.isEmpty() || emailInput.length() == 0) {
            editText.setError("Field cannot be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            editText.setError("Please enter a valid email address");
            return false;
        } else {
            editText.setError(null);
            return true;
        }
    }

    public static boolean validatePassword(EditText editText)
    {
        String passwordInput = editText.getText().toString().trim();

        if(passwordInput.isEmpty() || passwordInput.length() == 0) {
            editText.setError("Password must be at least 6 characters");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            editText.setError("Password too weak");
            return false;
        } else {
            editText.setError(null);
            return true;
        }
    }

}
