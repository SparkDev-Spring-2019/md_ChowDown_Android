package com.sparkdev.foodapp.mainscreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.mainscreen.FoodMenu.FoodMenuAdapter;

import java.util.ArrayList;

public class FoodMenuFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
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

    private int mPage;

    public static FoodMenuFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FoodMenuFragment fragment = new FoodMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foodmenu, container, false);

        populateArrays();

        // Get access to the RecyclerView
        foodMenuRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)
        foodMenuAdapter = new FoodMenuAdapter(getActivity(),foodItem, images, prices, categories , ratings,clockIcon, starIcon, leafIcon);
        // Connect the adapter to the RecyclerView
        foodMenuRecyclerView.setAdapter(foodMenuAdapter);
        // Define the RecyclerView's default layout manager
        foodMenuRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void populateArrays()
    {
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
    }
}