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
import com.sparkdev.foodapp.models.MenuCategory;
import com.sparkdev.foodapp.models.SingleMenuItem;
import com.sparkdev.foodapp.models.firebase.FirebaseAdapter;
import com.sparkdev.foodapp.models.firebase.foodMenuInterface.GetCategoryMenuItemsCompletionListener;

import java.util.ArrayList;
import java.util.List;

public class FoodMenuFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private RecyclerView foodMenuRecyclerView;
    private FoodMenuAdapter foodMenuAdapter;

    int clockIcon = R.drawable.clock_icon;
    int starIcon = R.drawable.star_icon;
    int leafIcon = R.drawable.leaf_icon;

    private int mPage;
    private static FirebaseAdapter fireBase;
    MenuCategory menuCategories = new MenuCategory("Lunch");
    List<SingleMenuItem> newMenuList = new ArrayList<>();


    public static FoodMenuFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FoodMenuFragment fragment = new FoodMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    // The FoodMenuActivity enters the created state when the activity is created for the first
    // time (i.e. when the user opens the application).
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foodmenu, container, false);

        fireBase = FirebaseAdapter.getInstance(getActivity());

        populateArrays();

        // Get access to the RecyclerView
        foodMenuRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        // Create the adapter and supply the adapter with the data (i.e from an arraylist or database)
        foodMenuAdapter = new FoodMenuAdapter(getActivity(), newMenuList);
        // Connect the adapter to the RecyclerView
        foodMenuRecyclerView.setAdapter(foodMenuAdapter);
        // Define the RecyclerView's default layout manager
        foodMenuRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void populateArrays()
    {

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




    }
}

//, prices, categories , ratings,clockIcon, starIcon, leafIcon