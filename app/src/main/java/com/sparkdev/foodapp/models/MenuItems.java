package com.sparkdev.foodapp.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuItems {

  private ArrayList<FoodMenuItem> mFoodMenuItems;

  public MenuItems(ArrayList<FoodMenuItem> foodMenuItems) {
    mFoodMenuItems = foodMenuItems;
  }

  public ArrayList<FoodMenuItem> getFoodMenuItems() {
    return mFoodMenuItems;
  }

  public ArrayList<Map<String, Object>> convertToMap() {

    ArrayList<Map<String, Object>> menuItemMap = new ArrayList<>();

    for (FoodMenuItem foodMenuItem: mFoodMenuItems) {
      menuItemMap.add(foodMenuItem.convertToMap());
    }

    return menuItemMap;
  }

}
