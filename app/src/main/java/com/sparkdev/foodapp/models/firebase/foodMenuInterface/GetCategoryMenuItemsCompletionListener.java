package com.sparkdev.foodapp.models.firebase.foodMenuInterface;


import com.sparkdev.foodapp.models.SingleMenuItem;

import java.util.List;

public interface GetCategoryMenuItemsCompletionListener {

  //method call when successful
  public void onSuccess(List<SingleMenuItem> menuItems);

  //method call when failure
  public void onFailure();
}
