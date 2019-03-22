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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;
import com.sparkdev.foodapp.models.MenuItemsCollection;
import com.sparkdev.foodapp.models.Order;
import com.sparkdev.foodapp.models.ReviewsCollection;
import com.sparkdev.foodapp.models.SingleMenuItem;
import com.sparkdev.foodapp.models.MenuCategory;
import com.sparkdev.foodapp.models.Review;
import com.sparkdev.foodapp.models.User;
import com.sparkdev.foodapp.models.firebase.foodMenuInterface.GetCategoryMenuItemsCompletionListener;
import com.sparkdev.foodapp.models.firebase.foodMenuInterface.GetMenuCategoriesCompletionListener;
import com.sparkdev.foodapp.models.firebase.loginInterface.GetUserCompletionListener;
import com.sparkdev.foodapp.models.firebase.loginInterface.LoginCompletionListener;
import com.sparkdev.foodapp.models.firebase.signupInterface.SignUpCompletionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirebaseAPI {

  // refer to a single instance of this class
  private static FirebaseAPI sFirebaseAPI;

  // constant to use as a tag for console log messages
  private static final String TAG = "FIREBASE";

  private FirebaseFirestore mFirestore;

  private FirebaseAPI(Context context) {
    // initialize the default FirebaseApp instance
    FirebaseApp.initializeApp(context);
    Log.d(TAG, "Firebase Firestore has been initialized");
    // get the default FirebaseDatabase instance
    mFirestore = FirebaseFirestore.getInstance();
    FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
        .setTimestampsInSnapshotsEnabled(true)
        .build();
    mFirestore.setFirestoreSettings(settings);
  }

  public static FirebaseAPI getInstance(Context context) {

    if (sFirebaseAPI != null) {
      return sFirebaseAPI;
    } else {
      sFirebaseAPI = new FirebaseAPI(context);
      return sFirebaseAPI;
    }
  }

  public void loginUser(String email, String password, final LoginCompletionListener listener) {

    FirebaseAuth auth = FirebaseAuth.getInstance();

    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
      @Override
      public void onComplete(@NonNull Task<AuthResult> task) {

        if (task.isSuccessful()) {
          AuthResult login = task.getResult();
          String uid = login.getUser().getUid();

          User.setCurrentUID(uid);

          getUserWithUID(uid, new GetUserCompletionListener() {
            @Override
            public void onSuccess(User user) {
              listener.onSuccess();
            }

            @Override
            public void onFailure() {
              listener.onFailure();
            }
          });

        } else {
          listener.onFailure();
        }

      }
    });

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

          // set an local instance of the current user by using their Firebase ID
             User.setCurrentUID(userId);

             // create the User object instance, refer to method getUserWithUID()
          getUserWithUID(userId, new GetUserCompletionListener() {
            @Override
            public void onSuccess(User user) {

              User.setCurrentUser(user);

            }

            @Override
            public void onFailure() {

              // do nothing

            }
          });


             // create a user document in the Users collection in Firestore
            CollectionReference usersRef = mFirestore.collection("Users");
            DocumentReference usersDocRef = usersRef.document(userId);

            // create a HashMap data structure that will later be turned into a JSON object using
          // Firebase's set() method
            HashMap<String, Object> user = new HashMap<>();
            user.put("email", email);
            user.put("firstName", "");  // create a first name field, user can change it later
            user.put("lastName", "");   // create a last name field, user can change it later
            user.put("address", "");    // create an address field, user can change it later

            // create the document with the above HashMap
            usersDocRef.set(user);

            // registration was successful, implement listener in activity to do what it needs to
            // do when a user is registered successfully
            listener.onSuccess();

        } else {
            // if registration was unsuccessful, implement listener in activity to do what it needs
            // to do when a user is NOT registered successfully
            listener.onFailure();
        }
      }
    });
    
  }

  public void getUserWithUID(String userID, final GetUserCompletionListener userCompletionListener) {
    // have a reference to the Users collection
    CollectionReference userRef = mFirestore.collection("Users");
    final DocumentReference userDoc = userRef.document(userID);

    userDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
      @Override
      public void onComplete(@NonNull Task<DocumentSnapshot> task) {

        if (task.isSuccessful()) {

          // get User from the Firebase Firestore base and convert it into a User java object
          User userObj = task.getResult().toObject(User.class);

          // if registration was successful, implement listener in registerUser() to do what it
          // needs to do when a user is NOT registered successfully

          userCompletionListener.onSuccess(userObj);

          // set the current User object instance
          User.setCurrentUser(userObj);

          // Log the current success
          Log.d(TAG, "Current user is: " + userObj.getEmail());

        } else {

          // if registration was unsuccessful, implement listener in registerUser() to do what it
          // needs to do when a user is NOT registered successfully

          userCompletionListener.onFailure();

          // Log the error message
          Log.d(TAG, task.getException().getMessage());

        }
      }
    });
  }

  public void getMenuCategories(final GetMenuCategoriesCompletionListener listener) {

    CollectionReference categoriesRef = mFirestore.collection("Categories");

    categoriesRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
      @Override
      public void onComplete(@NonNull Task<QuerySnapshot> task) {

        if (task.isSuccessful()) {

          List<MenuCategory> categories = new ArrayList<>();

          List<DocumentSnapshot> docs = task.getResult().getDocuments();

          for (DocumentSnapshot doc: docs) {

            MenuCategory menuCategory = doc.toObject(MenuCategory.class);
            categories.add(menuCategory);
          }

          listener.onSuccess(categories);

        } else {

          listener.onFailure();

        }

      }
    });

  }

  public void getMenuItems(MenuCategory menuCategory,
                           final GetCategoryMenuItemsCompletionListener listener){

    DocumentReference menuItemsRef =
        mFirestore.collection("MenuItems").document(menuCategory.getMenuItemsId());
    menuItemsRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
      @Override
      public void onComplete(@NonNull Task<DocumentSnapshot> task) {

        if (task.isSuccessful()) {

          DocumentSnapshot doc = task.getResult();

          MenuItemsCollection menuItemsCollection = doc.toObject(MenuItemsCollection.class);

          listener.onSuccess(menuItemsCollection.getFoodMenuItems());

        } else {

          listener.onFailure();

        }

      }
    });
  }

  public void submitReview(SingleMenuItem menuItem, final Review newReview,
                           final UpdateMenuItemReviewsCompletionListener listener) {

    DocumentReference menuItemRef =
        mFirestore.collection("MenuItems").document(menuItem.getCategoryId());

    DocumentReference menuItemReviewsRef =
        mFirestore.collection("Reviews").document(menuItem.getLatestReviewId());

    menuItemRef.update("latestReview", newReview.convertToMap());

    final DocumentReference reviewsRef =
        mFirestore.collection("Reviews").document(menuItem.getCategoryId());

    reviewsRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
      @Override
      public void onComplete(@NonNull Task<DocumentSnapshot> task) {

        if (task.isSuccessful()) {

          ReviewsCollection currReviews = task.getResult().toObject(ReviewsCollection.class);
          currReviews.addReview(newReview);

          reviewsRef.update("reviews", currReviews.convertToMap());

          listener.onSuccess();

        } else {

          listener.onFailure();

        }

      }
    });

  }


  // TODO
  public void updateReviews(SingleMenuItem menuItem, Review newReview,
                            final UpdateMenuItemReviewsCompletionListener listener) {

    DocumentReference menuItemRef =
        mFirestore.collection("MenuItems").document(menuItem.getCategoryId());

    DocumentReference menuItemReviewsRef =
        mFirestore.collection("Reviews").document(menuItem.getLatestReviewId());

    menuItemRef.update("latestReview", newReview.convertToMap());

  }

  // TODO
  public void newOrder(SingleMenuItem currMenuItem, final Order newOrder,
                       final NewOrderCompletionListener listener) {

  }
}
