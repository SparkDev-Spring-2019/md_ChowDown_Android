package com.sparkdev.foodapp.models.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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

  public void registerUser(final String email, String password, final SignUpCompletionListener listener) {

    // create an instance of the FirebaseAuth class
    FirebaseAuth auth = FirebaseAuth.getInstance();
    // call the createUserWithEmailAndPassword from the FirebaseAuth class and add a
    // listener to execute the argument after the user is registered in the Firebase Authentication
    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
        new OnCompleteListener<AuthResult>() {
      @Override
      public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
          // the user was successfully created in the Firebase Authentication area, BUT NOT in the
          // Firestore database so get the created user's random generated ID
          String userId = task.getResult().getUser().getUid();



        } else {

        }
      }
    });
    
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
