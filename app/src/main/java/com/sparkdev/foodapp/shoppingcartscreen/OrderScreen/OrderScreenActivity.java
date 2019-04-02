package com.sparkdev.foodapp.shoppingcartscreen.OrderScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkdev.foodapp.R;
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


    private List<OrderItem> orderItems = User.currentOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        //Set action bar title
        getSupportActionBar().setTitle("Your Order");
        Button button = findViewById(R.id.reviewButton);

        //create order list
        if(orderItems.isEmpty()){
            Toast.makeText(getApplicationContext(), "No items in cart yet", Toast.LENGTH_SHORT).show();
            button.setEnabled(false);
        }
        else{
            setUpRecyclerView();
            //setting total text view to the calculated total sum
            double total = addTotal();
            TextView totalText = findViewById(R.id.totalnumberTextview);
            totalText.setText("$" + String.format("%.2f", total));
            button.setEnabled(true);
        }


        //button listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConfirmationActivity.class);
                intent.putExtra("total", addTotal());
                startActivity(intent);
            }
        });
    }


    public double addTotal()
    {
        double total = 0;

        //looping price arraylist to calculate total
        for (int i = 0; i < orderItems.size(); i++)
        {
             total += orderItems.get(i).getFoodItem().getPrice() * orderItems.get(i).getQuantity();

        }
        return total;
    }

    public void setUpRecyclerView()
    {
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        // Get access to the RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)

        adapter = new OrderScreenAdapter(this, orderItems);

        // Connect the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
        // Define the RecyclerView's default layout manager
        recyclerView.setLayoutManager(llm);

        // Swipe gestures
//        ItemTouchHelper itemTouchHelper = new
//                ItemTouchHelper(new SwipeToDeleteCallback(adapter));
//        itemTouchHelper.attachToRecyclerView(recyclerView);

        // Add the line divider between each row
        itemDecoration = new DividerItemDecoration(recyclerView.getContext()
                , llm.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);
    }

}
