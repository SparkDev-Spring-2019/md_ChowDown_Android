package com.sparkdev.foodapp.profileSettings;

import com.sparkdev.foodapp.R;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class ProfileSettingsAdapter extends RecyclerView.Adapter<ProfileSettingsAdapter.ProfileViewHolder>{

    private final ArrayList<String> textInputList;    // This will hold your data
    private LayoutInflater profileInflater;       // This will be the inflater for ContactListAdapter

    // ContactListAdapter Constructor
    public ProfileSettingsAdapter (Context context, ArrayList<String> textInputList) {
        profileInflater = LayoutInflater.from(context); // Initialize the layout inflator
        this.textInputList = textInputList; // Initialize the arraylist
    }

    // Inner class to the ContactListAdapter and extends
    public class ProfileViewHolder extends RecyclerView.ViewHolder{
        // The following variables are for the text view and the adapter for each row
        public final TextView nameTextView;
        public final EditText editTextView;
        final ProfileSettingsAdapter rowAdapter;

        // Constructor where the first parameter is to inflate the layout and the second
        // parameter is to associate the ContactViewHolder with its adapter
        public ProfileViewHolder(View itemView, ProfileSettingsAdapter adapter) {
            super(itemView);
            // Initialize the view holder's text view from the XML resources (activity_contact_list.xml)
            // Be sure to cast it to the View type that you need it to be (i.e TextView)
            nameTextView = (TextView) itemView.findViewById(R.id.row_text);
            editTextView = (EditText) itemView.findViewById(R.id.row_edit);
            // Set up the adapter
            this.rowAdapter = adapter;
        }
    }


    // The onCreateViewHolder() method is very similar to the onCreate() method. In this method,
    // the LAYOUT will be inflated and it will return a view holder with the specified layout
    // and the corresponding adapter
    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Inflate the layout
        View customView = profileInflater.inflate(R.layout.profile_edit_text_row, viewGroup, false);
        // Return the new view holder
        return new ProfileViewHolder(customView, this);
    }

    // The onBindViewHolder() connects your data to your view holder
    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder contactViewHolder, int i) {
        String currentContact = textInputList.get(i);     // Hold the current contact name
        contactViewHolder.nameTextView.setText(currentContact); // Set contact name at i position to TextView
    }

    @Override
    public int getItemCount() {
        return textInputList.size();
    }
}

