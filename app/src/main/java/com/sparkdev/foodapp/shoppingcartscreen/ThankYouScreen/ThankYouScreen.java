package com.sparkdev.foodapp.shoppingcartscreen.ThankYouScreen;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sparkdev.foodapp.R;

import org.w3c.dom.Text;

import java.text.DateFormat;
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

            //sets current time
            calendar = Calendar.getInstance();
            dateFormat = new SimpleDateFormat("h:mm a");
            date = dateFormat.format(calendar.getTime());
            dateTimeDisplay = (TextView) findViewById(R.id.text_date_display);
            dateTimeDisplay.setText(date);


            final Button button = findViewById(R.id.button_id);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

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
                           dateTimeDisplay.setText("Your order is ready.");
                        }
                    });
                }
            }).start();
        }

        }




