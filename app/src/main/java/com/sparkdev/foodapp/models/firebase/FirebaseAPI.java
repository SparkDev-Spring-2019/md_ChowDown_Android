package com.sparkdev.foodapp.models.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sparkdev.foodapp.models.firebase.foodMenuInterface.GetMenuCompletionListener;
import com.sparkdev.foodapp.models.firebase.signupInterface.SignUpCompletionListener;

public class FirebaseAPI {

  // refer to a single instance of this class
  private static FirebaseAPI sFirebaseAPI;

  // constant to use as a tag for console log messages
  private static final String TAG = "FIREBASE_API";

  private FirebaseFirestore mFirestore;

  private FirebaseAPI(Context context) {
    // initialize the default FirebaseApp instance
    FirebaseApp.initializeApp(context);
    Log.d(TAG, "Firebase Database has been initialized");
    // get the default FirebaseDatabase instance
    mFirestore = FirebaseFirestore.getInstance();
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

  public void getMenu(final GetMenuCompletionListener listener) {

    CollectionReference menuRef = mFirestore.collection("Menu");

    menuRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
      @Override
      public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {

        } else {

        }
      }
    });
  }
}
