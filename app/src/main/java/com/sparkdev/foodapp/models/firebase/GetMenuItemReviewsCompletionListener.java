package com.sparkdev.foodapp.models.firebase;

import com.sparkdev.foodapp.models.Review;

import java.util.List;

public interface GetMenuItemReviewsCompletionListener {

  public void onSuccess(List<Review> reviews);

  public void onFailure();

}
