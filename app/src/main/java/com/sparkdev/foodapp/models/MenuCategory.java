package com.sparkdev.foodapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class MenuCategory implements Parcelable {


  private String categoryId;
  private HashMap<String, Object> menuItemsIds;

  public MenuCategory() {}

  public MenuCategory(String categoryId) {
    this.categoryId = categoryId;
  }

  protected MenuCategory(Parcel in) {
    categoryId = in.readString();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(categoryId);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<MenuCategory> CREATOR = new Creator<MenuCategory>() {
    @Override
    public MenuCategory createFromParcel(Parcel in) {
      return new MenuCategory(in);
    }

    @Override
    public MenuCategory[] newArray(int size) {
      return new MenuCategory[size];
    }
  };

  public String getCategoryId() {
    return categoryId;
  }

  public HashMap<String, Object> getMenuItemsIds() {
    return menuItemsIds;
  }
}
