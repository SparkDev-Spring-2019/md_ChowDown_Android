package com.sparkdev.foodapp.mainscreen.productpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkdev.foodapp.R;

import java.util.Date;

public class EditNameDialogFragment extends DialogFragment {

    private String userName = ReviewPageData.names[1]; //TODO: need a user object to define the creation of a review
    private EditText mEditText;
    private RatingBar mRatingBar;
    private Date timestamp;
    private String foodId = "Shwarma"; //TODO: need to get food id from food object

    public EditNameDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static EditNameDialogFragment newInstance(String title) {
        EditNameDialogFragment frag = new EditNameDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_popup_dialog, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = (TextView) view.findViewById(R.id.user_name);
        textView.setText(userName);

        // Get field from view
        mEditText = (EditText) view.findViewById(R.id.new_review_text);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        // Show soft keyboard automatically and request focus to field
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        mRatingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        Button button = (Button) view.findViewById(R.id.submit_review);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBackResult();
            }
        });




    }

    public ReviewsCollection allReviews = new ReviewsCollection();
    public Review review;

    // Defines the listener interface
    public interface EditNameDialogListener {
        void onFinishEditDialog(String inputText);
    }

    // Call this method to send the data back to the parent fragment
    public void sendBackResult() {
        // Notice the use of `getTargetFragment` which will be set when the dialog is displayed
        review = new Review(timestamp, mEditText.getText().toString(), userName, userName, foodId, (double) mRatingBar.getRating());  //user name and name being passed as the same need to differ? need a user object

        allReviews.addReview(review);

        Toast ts = Toast.makeText(getActivity(), mEditText.getText().toString(), Toast.LENGTH_LONG );
        ts.show();

        dismiss();
    }
}