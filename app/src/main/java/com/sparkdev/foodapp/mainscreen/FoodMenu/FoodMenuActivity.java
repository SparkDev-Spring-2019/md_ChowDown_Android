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
    private ArrayList<String> prices = new ArrayList<>();
    private ArrayList<String> categories = new ArrayList<>();
    private ArrayList<Double> ratings = new ArrayList<Double>();
    int clockIcon = R.drawable.clock_icon;
    int starIcon = R.drawable.star_icon;
    int leafIcon = R.drawable.leaf_icon;



    // The FoodMenuActivity enters the created state when the activity is created for the first
    // time (i.e. when the user opens the application).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        // Filling foodItem ArrayList
        String [] foodNameArray = {"Rice and Beans", "Tiramisu", "Pizza","Cake", "Arroz con leche"};
        for(int i = 0; i < foodNameArray.length; i++)
        {
            foodItem.add(foodNameArray[i]);
        }

        //Filling categories ArrayList
        String [] categoryArray = {"Category", "Category", "Category","Category","Category"};
        for(int i = 0; i < categoryArray.length; i++)
        {
            categories.add(categoryArray[i]);
        }

        //Filling ratings ArrayList
        double [] rateArray = {4.3, 4.8, 1.4, 3.6, 5.0};
        for(int i = 0; i < rateArray.length; i++)
        {
            ratings.add(rateArray[i]);
        }

        // Filling images ArrayList
        int [] imageArray = {R.drawable.riceandbeans, R.drawable.tiramisu, R.drawable.pizza,
                             R.drawable.cake, R.drawable.arrozconleche};
        for(int i = 0; i < imageArray.length; i++)
        {
            images.add(imageArray[i]);
        }

        //Fill prices ArrayList
        String [] pricesArray = {"$4.55", "$8.65", "$2.34", "$3.87", "$7.45"};
        for(int i = 0; i < pricesArray.length; i++)
        {
            prices.add(pricesArray[i]);
        }



        // Get access to the RecyclerView
        foodMenuRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)
        foodMenuAdapter = new FoodMenuAdapter(this,foodItem, images, prices, categories , ratings,clockIcon, starIcon, leafIcon);
        // Connect the adapter to the RecyclerView
        foodMenuRecyclerView.setAdapter(foodMenuAdapter);
        // Define the RecyclerView's default layout manager
        foodMenuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

//, prices, categories , ratings,clockIcon, starIcon, leafIcon