package com.sparkdev.foodapp.mainscreen.FoodMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.MenuCategory;
import com.sparkdev.foodapp.models.SingleMenuItem;
import com.sparkdev.foodapp.models.firebase.FirebaseAPI;
import com.sparkdev.foodapp.models.firebase.foodMenuInterface.GetCategoryMenuItemsCompletionListener;

import java.util.ArrayList;
import java.util.List;

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

    private static FirebaseAPI fireBase;
    MenuCategory menuCategories = new MenuCategory("Lunch", "EZW2eoJs7xH2B0Uvpnhl");
    List<SingleMenuItem> newMenuList;



    // The FoodMenuActivity enters the created state when the activity is created for the first
    // time (i.e. when the user opens the application).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        fireBase = FirebaseAPI.getInstance(this);
        fireBase.getMenuItems(menuCategories, new GetCategoryMenuItemsCompletionListener() {
            @Override
            public void onSuccess(List<SingleMenuItem> menuItems) {
                for(int i = 0; i < menuItems.size(); i++ )
                {
                   newMenuList.add(i, menuItems.get(i));
                }
            }

            @Override
            public void onFailure() {

            }
        });



        // Get access to the RecyclerView
        foodMenuRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)
        foodMenuAdapter = new FoodMenuAdapter(this, newMenuList);
        // Connect the adapter to the RecyclerView
        foodMenuRecyclerView.setAdapter(foodMenuAdapter);
        // Define the RecyclerView's default layout manager
        foodMenuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

//, prices, categories , ratings,clockIcon, starIcon, leafIcon