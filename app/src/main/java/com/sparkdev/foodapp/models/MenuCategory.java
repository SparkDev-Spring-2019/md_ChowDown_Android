package com.sparkdev.foodapp.models;

public class MenuCategory {

  private String categoryId;
  private String menuItemsId;

  public MenuCategory() {}

  public MenuCategory(String categoryId, String menuItemsId) {
    this.categoryId = categoryId;
    this.menuItemsId = menuItemsId;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public String getMenuItemsId() {
    return menuItemsId;
  }

}
