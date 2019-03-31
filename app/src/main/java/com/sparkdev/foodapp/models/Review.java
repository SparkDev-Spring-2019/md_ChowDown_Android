package com.sparkdev.foodapp.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Review {

  private Date timestamp;
  private String reviewMsg;
  private String reviewerId;
  private String reviewerName;
  private String foodId;
  private Double rating;

  public Review() {}

  public Review(Date timestamp, String reviewMsg, String reviewerId, String reviewerName, String foodId, Double rating) {
    this.timestamp = timestamp;
    this.reviewMsg = reviewMsg;
    this.reviewerId = reviewerId;
    this.reviewerName = reviewerName;
    this.foodId = foodId;
    this.rating = rating;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getReviewMsg() {
    return reviewMsg;
  }

  public String getReviewerId() {
    return reviewerId;
  }

  public String getReviewerName() {
    return reviewerName;
  }

  public String getFoodId() {
    return foodId;
  }

  public Double getRating() {
    return rating;
  }

  public Map<String, Object> convertToMap() {

    HashMap<String, Object> reviewMap = new HashMap<>();

    reviewMap.put("timestamp", timestamp);
    reviewMap.put("foodId", foodId);
    reviewMap.put("rating", rating);
    reviewMap.put("reviewMsg", reviewMsg);
    reviewMap.put("reviewerId", reviewerId);
    reviewMap.put("reviewerName", reviewerName);

    return reviewMap;
  }
}
