package com.sparkdev.foodapp.models.firebase;

import android.content.Context;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.sparkdev.foodapp.models.firebase.signupInterface.SignUpCompletionListener;

public class FirebaseAPI {

  // refer to a single instance of this class
  private static FirebaseAPI sFirebaseAPI;

  // constant to use as a tag for console log messages
  private static final String TAG = "FIREBASE_API";

  private FirebaseDatabase mDatabase;

  private FirebaseAPI(Context context) {
    // initialize the default FirebaseApp instance
    FirebaseApp.initializeApp(context);
    Log.d(TAG, "Firebase Database has been initialized");
    // get the default FirebaseDatabase instance
    mDatabase = FirebaseDatabase.getInstance();
  }

  public static FirebaseAPI getInstance(Context context) {

    if (sFirebaseAPI != null) {
      return sFirebaseAPI;
    } else {
      sFirebaseAPI = new FirebaseAPI(context);
      return sFirebaseAPI;
    }
  }

  public void registerUser(final String email, String password, String firstName, String lastName
      , final SignUpCompletionListener listener) {
    
  }
}
