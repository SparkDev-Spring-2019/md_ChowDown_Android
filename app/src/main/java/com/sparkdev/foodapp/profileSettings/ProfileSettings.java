package com.sparkdev.foodapp.profileSettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sparkdev.foodapp.R;

import java.util.ArrayList;
import java.util.Arrays;

/*
This class represents the ContactListActivity which will display all the contacts from an ArrayList.
 */

public class ProfileSettings extends AppCompatActivity {

    private RecyclerView profileRecyclerView;
    private ProfileSettingsAdapter profileAdapter;
    private ArrayList<String> text_rows = new ArrayList<>();

    // The ContactListActivity enters the created state when the activity is created for the first
    // time (i.e. when the user opens the application).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        // Add contacts to the contacts ArrayList
        for(int i = 0; i < 30; i++){
            text_rows.add("Contact " + i);
        }

        // Get access to the RecyclerView
        profileRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)
        profileAdapter = new ProfileSettingsAdapter(this,text_rows);
        // Connect the adapter to the RecyclerView
        profileRecyclerView.setAdapter(profileAdapter);
        // Define the RecyclerView's default layout manager
        profileRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
