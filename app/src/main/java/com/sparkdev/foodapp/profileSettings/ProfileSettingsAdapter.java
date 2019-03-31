package com.sparkdev.foodapp.profileSettings;

import com.sparkdev.foodapp.R;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.util.AdapterListUpdateCallback;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ProfileSettingsAdapter extends RecyclerView.Adapter<ProfileSettingsAdapter.ProfileViewHolder> {

    private final ArrayList<String> textInputList;    // This will hold your data
    private LayoutInflater profileInflater;       // This will be the inflater for ContactListAdapter

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    ".{6,}" +               //at least 6 characters
                    "$");



    // ContactListAdapter Constructor
    public ProfileSettingsAdapter(Context context, ArrayList<String> textInputList) {
        profileInflater = LayoutInflater.from(context); // Initialize the layout inflator
        this.textInputList = textInputList; // Initialize the arraylist
        
    }

    // Inner class to the ContactListAdapter and extends
    public class ProfileViewHolder extends RecyclerView.ViewHolder {
        // The following variables are for the text view and the adapter for each row
        public final TextView nameTextView;
        public final TextInputLayout editTextView;
        final ProfileSettingsAdapter rowAdapter;


        // Constructor where the first parameter is to inflate the layout and the second
        // parameter is to associate the ContactViewHolder with its adapter
        public ProfileViewHolder(View itemView, ProfileSettingsAdapter adapter) {
            super(itemView);
            // Initialize the view holder's text view from the XML resources (activity_contact_list.xml)
            // Be sure to cast it to the View type that you need it to be (i.e TextView)
            nameTextView = (TextView) itemView.findViewById(R.id.row_title);
            editTextView = (TextInputLayout) itemView.findViewById(R.id.text_input);

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
    public void onBindViewHolder(@NonNull final ProfileViewHolder contactViewHolder, final int i) {

        String currentInput = textInputList.get(i);     // Hold the current text field
        contactViewHolder.nameTextView.setText(currentInput); // Set text field at i position to TextView
        contactViewHolder.editTextView.getEditText().setText("Guirdelle"); //previous user input

        contactViewHolder.editTextView.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //validate each row
                if (i == 0) {

                    //first name
                    String firstNameInput = contactViewHolder.editTextView.getEditText().getText().toString().trim();

                    if (firstNameInput.isEmpty()) {
                        contactViewHolder.editTextView.setError("Field cannot be empty");
                    } else if (!firstNameInput.matches("[a-zA-Z]*")) {
                        contactViewHolder.editTextView.setError("Field can only contain letters");
                    } else {
                        contactViewHolder.editTextView.setError(null);
                    }

                } else if (i == 1) {

                    //last name
                    String lastNameInput = contactViewHolder.editTextView.getEditText().getText().toString().trim();

                    if (lastNameInput.isEmpty()) {
                        contactViewHolder.editTextView.setError("Field cannot be empty");
                    } else if (!lastNameInput.matches("[a-zA-Z]*")) {
                        contactViewHolder.editTextView.setError("Field can only contain letters");
                    } else {
                        contactViewHolder.editTextView.setError(null);
                    }

                } else if (i == 2) {

                    //username
                    String usernameInput = contactViewHolder.editTextView.getEditText().getText().toString().trim();

                    if (usernameInput.isEmpty()) {
                        contactViewHolder.editTextView.setError("Field cannot be empty");
                    } else if (usernameInput.length() > 15) {
                        contactViewHolder.editTextView.setError("Username must be 15 characters or less");
                    } else {
                        contactViewHolder.editTextView.setError(null);
                    }

                } else if (i == 3) {

                    //email
                    String emailInput = contactViewHolder.editTextView.getEditText().getText().toString().trim();

                    if(emailInput.isEmpty()) {
                        contactViewHolder.editTextView.setError("Field cannot be empty");
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                        contactViewHolder.editTextView.setError("Please enter a valid email address");
                    } else {
                        contactViewHolder.editTextView.setError(null);
                    }

                } else if (i == 4) {

                    //password
                    String passwordInput = contactViewHolder.editTextView.getEditText().getText().toString().trim();

                    if(passwordInput.isEmpty()) {
                        contactViewHolder.editTextView.setError("Password must be at least 6 characters");
                    } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
                        contactViewHolder.editTextView.setError("Password too weak");
                    } else {
                        contactViewHolder.editTextView.setError(null);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return textInputList.size();
    }

}