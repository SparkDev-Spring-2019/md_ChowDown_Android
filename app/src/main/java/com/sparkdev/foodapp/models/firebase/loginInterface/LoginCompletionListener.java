package com.sparkdev.foodapp.models.firebase.loginInterface;

public interface LoginCompletionListener {

  //method call when login is successful
  public void onSuccess();

  //method call when login is failure
  public void onFailure();
  
}
