package com.sparkdev.foodapp.models;

import java.util.HashMap;
import java.util.Map;

public class FoodMenuItem {

  private String foodId;
  private String foodName;
  private String description;
  private String foodImgUrl;

  public Map<String, Object> convertToMap() {

    HashMap<String, Object> foodMenuItemMap = new HashMap<>();

    foodMenuItemMap.put("foodId", foodId);

    return foodMenuItemMap;
  }

}
