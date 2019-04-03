package com.sparkdev.foodapp.mainscreen.productpage;

import android.app.Activity;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.Review;
import com.sparkdev.foodapp.models.SingleMenuItem;
import com.sparkdev.foodapp.models.User;
import com.sparkdev.foodapp.models.firebase.FirebaseAdapter;
import com.sparkdev.foodapp.models.firebase.UpdateMenuItemReviewsCompletionListener;

import java.util.Date;

public class ReviewSubmissionPage extends AppCompatActivity implements View.OnClickListener {
    User user = User.currentUser;
    FirebaseAdapter firebaseAdapter;
    Button submit;
    TextView userNameBox;
    EditText userReview;
    String userName = user.getFirstName();
    RatingBar ratingBar;
    String newReview;
    SingleMenuItem currentMenuItem ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_review_submission);

        firebaseAdapter = FirebaseAdapter.getInstance(this);

        userNameBox = (TextView) findViewById(R.id.user_name);
        userNameBox.setText(userName);

        userReview = (EditText) findViewById(R.id.new_review_text);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        double rating = (double) ratingBar.getRating();

        submit = (Button) findViewById(R.id.submit_review);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitReview();
            }
        });

        currentMenuItem = getIntent().getParcelableExtra("food_item");
    }

    Date timeStamp = new Date();
    Review submitReview;


    private void submitReview() {
        newReview = userReview.getText().toString();
        submitReview = new Review(timeStamp, newReview, userName, userName, currentMenuItem.getId(), (double) ratingBar.getRating());
        firebaseAdapter.submitReview(currentMenuItem, submitReview, new UpdateMenuItemReviewsCompletionListener() {
            @Override
            public void onSuccess() {
//                Toast ts = Toast.makeText(, "Success", Toast.LENGTH_LONG);
//                ts.show();
                finish();
            }

            @Override
            public void onFailure() {

            }

        });



    }

    @Override
    public void onClick(View v) {

    }
}
