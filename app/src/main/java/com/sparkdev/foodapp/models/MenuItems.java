package com.sparkdev.foodapp.models;

import java.util.ArrayList;
import java.util.Map;

public class MenuItems {

  private ArrayList<SingleMenuItem> mFoodMenuItems;

  public MenuItems(ArrayList<SingleMenuItem> foodMenuItems) {
    mFoodMenuItems = foodMenuItems;
  }

  public ArrayList<SingleMenuItem> getFoodMenuItems() {
    return mFoodMenuItems;
  }

  public ArrayList<Map<String, Object>> convertToMap() {

    ArrayList<Map<String, Object>> menuItemMap = new ArrayList<>();

    for (SingleMenuItem foodMenuItem: mFoodMenuItems) {
      menuItemMap.add(foodMenuItem.convertToMap());
    }

    return menuItemMap;
  }

}
