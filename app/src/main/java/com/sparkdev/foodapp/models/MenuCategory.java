package com.sparkdev.foodapp.models;

import java.util.HashMap;

public class MenuCategory {

  private String categoryId;
  private HashMap<String, Object> menuItemsIds;

  public MenuCategory() {}

  public MenuCategory(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public HashMap<String, Object> getMenuItemsIds() {
    return menuItemsIds;
  }
}
