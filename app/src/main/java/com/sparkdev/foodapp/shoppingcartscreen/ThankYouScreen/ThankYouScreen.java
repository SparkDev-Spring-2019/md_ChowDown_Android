package com.sparkdev.foodapp.shoppingcartscreen.ThankYouScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.mainscreen.TabLayoutActivity;
import com.sparkdev.foodapp.models.User;


import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ThankYouScreen extends AppCompatActivity {



        private ProgressBar mProgressBar;
        private TextView mLoadingText;
        private int mProgressStatus = 0;
        private Handler mHandler = new Handler();

        private TextView dateTimeDisplay;
        private Calendar calendar;
        private SimpleDateFormat dateFormat;
        private String date;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_thank_you_screen);

            //receive information from previous activity
            Intent intent = getIntent();
            String address = intent.getStringExtra("address");

            //get views
            TextView textView = findViewById(R.id.userName);
            TextView addressText = findViewById(R.id.addressText);

            //set text for user
            if(User.currentUser != null) {
                String name = User.currentUser.getFirstName();
                textView.setText(name + ", we received your order.");
            }

            //change delivery text based on isDelivery
            Boolean delivery = intent.getBooleanExtra("isDelivery", false);
            TextView textView2 = findViewById(R.id.deliveryAddress);
            TextView textView3 = findViewById(R.id.expectedDelivery);

            if (delivery == true){
                textView2.setText("Delivery Address: ");
                textView3.setText("Expected Delivery: ");
                addressText.setText(address);
            }
            else {
                textView2.setText("Pickup Address: ");
                textView3.setText("Order is ready for pickup at: ");
            }






            //sets current time
            calendar = Calendar.getInstance();
            dateFormat = new SimpleDateFormat("h:mm a");
            date = dateFormat.format(calendar.getTime());
            dateTimeDisplay = (TextView) findViewById(R.id.text_date_display);
            dateTimeDisplay.setText(date);

            //button to go to mainscreen
            final Button button = findViewById(R.id.button_id);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent (ThankYouScreen.this, TabLayoutActivity.class);
                    startActivity(intent);
                }
            });

            //progress bar
            mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (mProgressStatus < 100) {
                        mProgressStatus++;
                        android.os.SystemClock.sleep(500);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mProgressBar.setProgress(mProgressStatus);
                            }
                        });
                    }
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                           dateTimeDisplay.setText("Your order is ready!");
                        }
                    });
                }
            }).start();


        }

        }




