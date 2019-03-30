package com.sparkdev.foodapp.models;

import java.util.HashMap;
import java.util.Map;

public class OrderItem {
    private SingleMenuItem foodItem;
    private int quantity;
    private String size;

    public OrderItem(){}

    public OrderItem(SingleMenuItem foodItem, int quantity, String size){
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.size = size;

    }


    public SingleMenuItem getFoodItem() {
        return foodItem;
    }

    public void setFoodId(SingleMenuItem foodItem) {
        this.foodItem = foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Map<String, Object> convertToMap() {

        HashMap<String, Object> orderItemMap = new HashMap<>();
        orderItemMap.put("foodItem", foodItem);
        orderItemMap.put("quantity", quantity);
        orderItemMap.put("size", size);

        return orderItemMap;
    }
}
