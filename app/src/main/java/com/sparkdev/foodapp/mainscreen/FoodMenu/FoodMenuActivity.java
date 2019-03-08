package com.sparkdev.foodapp.mainscreen.FoodMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.sparkdev.foodapp.R;
import java.util.ArrayList;

/*
This class represents the FoodMenuActivity which will display all the contacts from an ArrayList.
 */

public class FoodMenuActivity extends AppCompatActivity {

    private RecyclerView foodMenuRecyclerView;
    private FoodMenuAdapter foodMenuAdapter;
    private ArrayList<String> foodItem = new ArrayList<>();
    private ArrayList<Integer> images = new ArrayList<>();


    // The FoodMenuActivity enters the created state when the activity is created for the first
    // time (i.e. when the user opens the application).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        // Filling foodItem ArrayList
        String [] categoryArray = {"Rice and Beans", "Tiramisu", "Pizza","Cake", "Arroz con leche"};
        for(int i = 0; i < categoryArray.length; i++)
        {
            foodItem.add(categoryArray[i]);
        }

        // Filling images ArrayList
        int [] imageArray = {R.drawable.riceandbeans, R.drawable.tiramisu, R.drawable.pizza,
                             R.drawable.cake, R.drawable.arrozconleche};
        for(int i = 0; i < imageArray.length; i++)
        {
            images.add(imageArray[i]);
        }



        // Get access to the RecyclerView
        foodMenuRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)
        foodMenuAdapter = new FoodMenuAdapter(this,foodItem, images);
        // Connect the adapter to the RecyclerView
        foodMenuRecyclerView.setAdapter(foodMenuAdapter);
        // Define the RecyclerView's default layout manager
        foodMenuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
