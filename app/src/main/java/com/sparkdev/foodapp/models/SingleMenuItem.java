package com.sparkdev.foodapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SingleMenuItem implements Parcelable {

  private String id;
  private ArrayList<String> category;
  private String name;
  private String description;
  private String foodImageUrl;
  private Double rating;
  private Double price;
  private Integer completionTime;
  private Boolean isVegan;
  private String reviewsRefId;

  public SingleMenuItem() {}

  public SingleMenuItem(String foodId, String reviewsRefId) {
    this.id = foodId;
    this.reviewsRefId = reviewsRefId;
  }

  public SingleMenuItem(String foodName, String description, String reviewsRefId)
  {
    name = foodName;
    this.description = description;
    this.reviewsRefId = reviewsRefId;
  }

  public SingleMenuItem(String foodImageUrl, double price, String name)
  {
    this.foodImageUrl = foodImageUrl;
    this.price = price;
    this.name = name;
  }

  public SingleMenuItem(String id, ArrayList<String> category, String name, String description, String foodImageUrl, Double rating, Double price, Integer completionTime, Boolean isVegan, String reviewsRefId, HashMap<String, Object> reviewIds) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.description = description;
    this.foodImageUrl = foodImageUrl;
    this.rating = rating;
    this.price = price;
    this.completionTime = completionTime;
    this.isVegan = isVegan;
    this.reviewsRefId = reviewsRefId;
  }

  protected SingleMenuItem(Parcel in) {
    id = in.readString();
    category = in.createStringArrayList();
    name = in.readString();
    description = in.readString();
    foodImageUrl = in.readString();
    if (in.readByte() == 0) {
      rating = null;
    } else {
      rating = in.readDouble();
    }
    if (in.readByte() == 0) {
      price = null;
    } else {
      price = in.readDouble();
    }
    if (in.readByte() == 0) {
      completionTime = null;
    } else {
      completionTime = in.readInt();
    }
    isVegan = in.readInt() == 1;
    reviewsRefId = in.readString();
  }

  public static final Creator<SingleMenuItem> CREATOR = new Creator<SingleMenuItem>() {
    @Override
    public SingleMenuItem createFromParcel(Parcel in) {
      return new SingleMenuItem(in);
    }

    @Override
    public SingleMenuItem[] newArray(int size) {
      return new SingleMenuItem[size];
    }
  };

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ArrayList<String> getCategory() {
    return category;
  }

  public void setCategory(ArrayList<String> category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFoodImageUrl() {
    return foodImageUrl;
  }

  public void setFoodImageUrl(String foodImageUrl) {
    this.foodImageUrl = foodImageUrl;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getCompletionTime() {
    return completionTime;
  }

  public void setCompletionTime(Integer completionTime) {
    this.completionTime = completionTime;
  }

  public Boolean getIsVegan(){return isVegan;}

  public void setIsVegan(Boolean isVegan){this.isVegan = isVegan;}

  public String getReviewsRefId() {
    return reviewsRefId;
  }

  public void setReviewsRefId(String reviewsRefId) {
    this.reviewsRefId = reviewsRefId;
  }


  public Map<String, Object> convertToMap() {

    HashMap<String, Object> singleMenuItemMap = new HashMap<>();

    singleMenuItemMap.put("id", id);
    singleMenuItemMap.put("category", category);
    singleMenuItemMap.put("name", name);
    singleMenuItemMap.put("description", description);
    singleMenuItemMap.put("foodImageUrl", foodImageUrl);
    singleMenuItemMap.put("rating", rating);
    singleMenuItemMap.put("price", price);
    singleMenuItemMap.put("completionTime", completionTime);
    singleMenuItemMap.put("isVegan", isVegan);
    singleMenuItemMap.put("reviewsRefId", reviewsRefId);

    return singleMenuItemMap;
  }


  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(id);
    parcel.writeStringList(category);
    parcel.writeString(name);
    parcel.writeString(description);
    parcel.writeString(foodImageUrl);
    if (rating == null) {
      parcel.writeByte((byte) 0);
    } else {
      parcel.writeByte((byte) 1);
      parcel.writeDouble(rating);
    }
    if (price == null) {
      parcel.writeByte((byte) 0);
    } else {
      parcel.writeByte((byte) 1);
      parcel.writeDouble(price);
    }
    if (completionTime == null) {
      parcel.writeByte((byte) 0);
    } else {
      parcel.writeByte((byte) 1);
      parcel.writeInt(completionTime);
    }
    parcel.writeInt(isVegan ? 1 : 0);
    parcel.writeString(reviewsRefId);
  }
}
