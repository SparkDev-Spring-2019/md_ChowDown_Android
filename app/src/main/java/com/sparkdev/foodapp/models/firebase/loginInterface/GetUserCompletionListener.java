package com.sparkdev.foodapp.models.firebase.loginInterface;

import com.sparkdev.foodapp.models.User;

public interface GetUserCompletionListener {

  public  void onSuccess(User user);

  public void onFailure();
}
