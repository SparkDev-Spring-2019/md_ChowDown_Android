package com.sparkdev.foodapp.shoppingcartscreen.OrderScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sparkdev.foodapp.R;

import java.util.ArrayList;

public class OrderScreenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrderScreenAdapter adapter;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);


        // Add items to the items ArrayList
        for(int i = 0; i < 30; i++){
            itemList.add("Contact " + i);
        }


        // Get access to the RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)
        adapter = new OrderScreenAdapter(this,itemList);
        // Connect the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
        // Define the RecyclerView's default layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
