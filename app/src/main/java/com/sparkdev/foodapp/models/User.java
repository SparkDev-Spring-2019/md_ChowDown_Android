package com.sparkdev.foodapp.models;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.firestore.PropertyName;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String fullAddress;
    private ArrayList<String> preferences;
    private String profileImageUrl;
    private String ordersRef;

    private String userId;

    public static User currentUser;
    public static String currentUID;
    public static List<OrderItem> currentOrder;


    public User(String email, String password, String address, String city, String state, String zipCode) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.fullAddress = address + city + state + zipCode;
    }

  public User() {}

  public User(String userId, String ordersRef)
  {
      this.userId = userId;
      this.ordersRef = ordersRef;
  }



  public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void addPreference(String pref){
        preferences.add(pref);
    }

    public void delPreference(String pref){
        preferences.remove(pref);
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName){
         this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setOrdersRef(String newOrderRef)
    {
        this.ordersRef = newOrderRef;
    }

    public String getOrdersRef()
    {
        return ordersRef;
    }

    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }

    public static void setCurrentUID(String currentUID) {
        User.currentUID = currentUID;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public static List<OrderItem> getCurrentOrder(){
        return currentOrder;
    }

    public static void setCurrentOrder(List<OrderItem> orderItems){
        orderItems = currentOrder;
    }
}
