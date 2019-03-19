package com.sparkdev.foodapp.models;

import java.util.HashMap;

public class MenuCategory {

  private String categoryId;
  private HashMap<String, Object> foodIds;

  public MenuCategory() {}

  public MenuCategory(String categoryId, HashMap<String, Object> foodIds) {
    this.categoryId = categoryId;
    this.foodIds = foodIds;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public HashMap<String, Object> getFoodIds() {
    return foodIds;
  }

}
