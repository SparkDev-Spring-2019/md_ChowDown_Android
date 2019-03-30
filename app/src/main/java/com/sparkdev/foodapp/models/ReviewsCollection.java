package com.sparkdev.foodapp.models;

import java.util.ArrayList;
import java.util.Map;

public class ReviewsCollection {

  private ArrayList<Review> mReviews;

  public ReviewsCollection() {}

  public ReviewsCollection(ArrayList<Review> reviews) {
    mReviews = reviews;
  }

  public ArrayList<Review> getReviews() {
    return mReviews;
  }

  public void setReviews(ArrayList<Review> reviews) {
    mReviews = reviews;
  }

  public void addReview(Review newReview) {
    mReviews.add(newReview);
  }

  public void calculateRating(Review newReview) {

  }

  public ArrayList<Map<String, Object>> convertToMap() {

    ArrayList<Map<String, Object>> reviewsMap = new ArrayList<>();

    for (Review review: mReviews) {
      reviewsMap.add(review.convertToMap());
    }

    return reviewsMap;
  }
}
