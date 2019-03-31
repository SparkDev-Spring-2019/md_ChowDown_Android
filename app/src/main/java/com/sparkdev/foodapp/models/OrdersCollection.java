package com.sparkdev.foodapp.models;

import java.util.ArrayList;
import java.util.Map;

public class OrdersCollection {
    ArrayList <Order> orders;

    public OrdersCollection(){}

    public OrdersCollection(ArrayList<Order> orders){
        this.orders = orders;
    }

    public ArrayList<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(ArrayList<Order> newOrders)
    {
        orders = newOrders;
    }

    public void addOrder(Order newOrder)
    {
        orders.add(newOrder);
    }

    public ArrayList<Map<String, Object>> convertToMap() {

        ArrayList<Map<String, Object>> ordersMap = new ArrayList<>();

        for (Order orders: this.orders) {
            ordersMap.add(orders.convertToMap());
        }

        return ordersMap;
    }
}
