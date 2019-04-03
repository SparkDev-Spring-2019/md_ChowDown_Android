package com.sparkdev.foodapp.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO
public class Order {
    private String userId;
    private List<OrderItem> orderItems;
    private String orderId;

    public Order(){}

    public Order(String userId, List<OrderItem> orderItems, String orderId)
    {
        this.userId = userId;
        this.orderId = orderId;
        this.orderItems = orderItems;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Map<String, Object> convertToMap() {

        HashMap<String, Object> orderMap = new HashMap<>();
        orderMap.put("userId", userId);
        orderMap.put("orderId", orderId);
        orderMap.put("orderItems", orderItems);

        return orderMap;
    }
}
