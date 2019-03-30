package com.sparkdev.foodapp.shoppingcartscreen.OrderScreen;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.Order;
import com.sparkdev.foodapp.models.OrderItem;
import com.sparkdev.foodapp.models.SingleMenuItem;
import com.sparkdev.foodapp.models.User;
import com.sparkdev.foodapp.shoppingcartscreen.confirmationscreen.ConfirmationActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderScreenActivity extends AppCompatActivity {

    private LinearLayoutManager llm;
    private RecyclerView recyclerView;
    private OrderScreenAdapter adapter;
    private DividerItemDecoration itemDecoration;


    private OrderItem orderItem;
    private SingleMenuItem menuItem;
    private ArrayList<OrderItem> orderList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        //Set action bar title
        getSupportActionBar().setTitle("Your Order");

       //populate data
        menuItem = new SingleMenuItem("https://firebasestorage.googleapis.com/v0/b/foodapp-eeb94.appspot.com/o/Food%2Fcheesecake.jpg?alt=media&token=8f66127f-fe59-4f16-816d-d93af9ffc605",
                2.30,"cheescake");
        orderItem = new OrderItem(menuItem,5,"medium");
        orderList = new ArrayList<>();


        //add item to list
        orderList.add(orderItem);



        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        // Get access to the RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)

        adapter = new OrderScreenAdapter(this, orderList);

        // Connect the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
        // Define the RecyclerView's default layout manager
        recyclerView.setLayoutManager(llm);

        // Swipe gestures
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);

        // Add the line divider between each row
        itemDecoration = new DividerItemDecoration(recyclerView.getContext()
                , llm.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);

        Button button = findViewById(R.id.reviewButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConfirmationActivity.class);
                startActivity(intent);
            }
        });
    }



}
