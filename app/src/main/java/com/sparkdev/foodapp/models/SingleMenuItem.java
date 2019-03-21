package com.sparkdev.foodapp.models;

import java.util.HashMap;
import java.util.Map;

public class SingleMenuItem {

  private String categoryId;
  private String foodId;
  private String foodName;
  private String description;
  private String foodImgUrl;
  private Double rating;
  private Integer completionTime;
  private Boolean isVegan;
  private String latestReviewId;
  private HashMap<String, Review> reviewIds;

  public SingleMenuItem() {}

  public SingleMenuItem(String categoryId, String foodId, String foodName, String description, String foodImgUrl, Double rating, Integer completionTime, Boolean isVegan, String latestReviewId, HashMap<String, Review> reviewIds) {
    this.categoryId = categoryId;
    this.foodId = foodId;
    this.foodName = foodName;
    this.description = description;
    this.foodImgUrl = foodImgUrl;
    this.rating = rating;
    this.completionTime = completionTime;
    this.isVegan = isVegan;
    this.latestReviewId = latestReviewId;
    this.reviewIds = reviewIds;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public String getFoodId() {
    return foodId;
  }

  public String getFoodName() {
    return foodName;
  }

  public String getDescription() {
    return description;
  }

  public String getFoodImgUrl() {
    return foodImgUrl;
  }

  public Double getRating() {
    return rating;
  }

  public Integer getCompletionTime() {
    return completionTime;
  }

  public Boolean getVegan() {
    return isVegan;
  }

  public String getLatestReviewId() {
    return latestReviewId;
  }

  public HashMap<String, Review> getReviewIds() {
    return reviewIds;
  }

  public Map<String, Object> convertToMap() {

    HashMap<String, Object> singleMenuItemMap = new HashMap<>();

    singleMenuItemMap.put("categoryId", categoryId);
    singleMenuItemMap.put("foodId", foodId);
    singleMenuItemMap.put("foodName", foodName);
    singleMenuItemMap.put("description", description);
    singleMenuItemMap.put("foodImageUrl", foodImgUrl);
    singleMenuItemMap.put("rating", rating);
    singleMenuItemMap.put("completionTime", completionTime);
    singleMenuItemMap.put("isVegan", isVegan);
    singleMenuItemMap.put("reviewIds", reviewIds);

    return singleMenuItemMap;
  }

}
