package com.sparkdev.foodapp.models.firebase.foodMenuInterface;

import com.sparkdev.foodapp.models.MenuCategory;

import java.util.List;

public interface GetMenuCategoriesCompletionListener {

  //method call when successful
  public void onSuccess(List<MenuCategory> menuCategories);

  //method call when failure
  public void onFailure();

}
