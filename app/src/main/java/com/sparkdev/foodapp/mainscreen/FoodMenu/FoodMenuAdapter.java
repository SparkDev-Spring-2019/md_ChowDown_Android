package com.sparkdev.foodapp.mainscreen.FoodMenu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sparkdev.foodapp.R;

import java.util.ArrayList;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.FoodItemViewHolder>{

    private final ArrayList<String> menuItem;    // This will hold your data
    private final ArrayList<Integer>pictures;
    private final ArrayList<String> itemPrice;
    private final ArrayList<String> categories;
    private final ArrayList<Double> ratings;
    private final int clockIcon;
    private final int starIcon;
    private final int leafIcon;


    private LayoutInflater menuInflater;       // This will be the inflater for FoodMenuAdapter


    // FoodMenuAdapter Constructor
    public FoodMenuAdapter(Context context, ArrayList<String> foodItem, ArrayList<Integer> pictures,
                           ArrayList<String> itemPrice,ArrayList<String> categories, ArrayList<Double> ratings,
                           int clockIcon,int starIcon, int leafIcon)
    {
        menuInflater = LayoutInflater.from(context); // Initialize the layout inflator
        this.menuItem = foodItem; // Initialize the arraylist
        this.pictures = pictures;
        this.itemPrice = itemPrice;
        this.categories = categories;
        this.ratings = ratings;
        this.clockIcon = clockIcon;
        this.starIcon = starIcon;
        this.leafIcon = leafIcon;
    }

    // Inner class to the FoodMenuAdapter and extends
    public class FoodItemViewHolder extends RecyclerView.ViewHolder{
        // The following variables are for the text view and the adapter for each row
        public final TextView nameTextView;
        public final TextView itemPrice;
        public final ImageView foodImage;
        public final TextView itemRate;
        public final TextView itemCategory;
        public final ImageView clockPic;
        public final ImageView leafPic;
        public final ImageView starPic;
        final FoodMenuAdapter rowAdapter;

        // Constructor where the first parameter is to inflate the layout and the second
        // parameter is to associate the FoodItemViewHolder with its adapter
        public FoodItemViewHolder(View itemView, FoodMenuAdapter adapter) {
            super(itemView);
            // Initialize the view holder's text view from the XML resources (fragment_foodmenu.xml          // Be sure to cast it to the View type that you need it to be (i.e TextView)
            nameTextView = (TextView) itemView.findViewById(R.id.menuItem_name);
            itemPrice = (TextView) itemView.findViewById(R.id.price_textView);
            itemRate = (TextView) itemView.findViewById(R.id.rate_textView);
            itemCategory = (TextView) itemView.findViewById(R.id.categories_textView);
            foodImage  = (ImageView) itemView.findViewById(R.id.foodItem_image);
            foodImage.setClipToOutline(true);
            clockPic = (ImageView) itemView.findViewById(R.id.clock_icon);
            leafPic = (ImageView) itemView.findViewById(R.id.leaf_icon);
            starPic = (ImageView) itemView.findViewById(R.id.star_icon);

             //Set up the adapter
            this.rowAdapter = adapter;
        }
    }


    // The onCreateViewHolder() method is very similar to the onCreate() method. In this method,
    // the LAYOUT will be inflated and it will return a view holder with the specified layout
    // and the corresponding adapter
    @Override
    public FoodItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Inflate the layout
        View customView = menuInflater.inflate(R.layout.fragment_foodmenu_single_item, viewGroup, false);
        // Return the new view holder
        return new FoodItemViewHolder(customView, this);
    }

    // The onBindViewHolder() connects your data to your view holder
    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder foodItemViewHolder, int i) {
        String currentContact = menuItem.get(i);     // Hold the current contact name
        String currentItemPrice = itemPrice.get(i);
        String currentRate = Double.toString(ratings.get(i));
        int currentImage = pictures.get(i);
        String currentCategory = categories.get(i);

        foodItemViewHolder.nameTextView.setText(currentContact); // Set contact name at i position to TextView
        foodItemViewHolder.foodImage.setImageResource(currentImage);
        foodItemViewHolder.itemPrice.setText(currentItemPrice);
        foodItemViewHolder.itemRate.setText(currentRate);
        foodItemViewHolder.itemCategory.setText(currentCategory);
    }

    @Override
    public int getItemCount() {
        return menuItem.size();
    }
}
