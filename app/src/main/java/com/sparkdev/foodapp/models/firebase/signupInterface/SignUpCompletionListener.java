package com.sparkdev.foodapp.models.firebase.signupInterface;

public interface SignUpCompletionListener {

  //method call when signup is successful
  public void onSuccess();

  //method call when signup is failure
  public void onFailure();

}
