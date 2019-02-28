package com.sparkdev.foodapp.models.firebase.foodMenuInterface;

import com.sparkdev.foodapp.models.FoodMenuItem;

import java.util.List;

public interface UpdateMenuCompletionListener {

  //method call when update is successful
  public void onSuccess(List<FoodMenuItem> foodMenuItems);

  //method call when update is failure
  public void onFailure();

}
