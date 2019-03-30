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
import com.sparkdev.foodapp.models.SingleMenuItem;

import java.util.List;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.ContactViewHolder>{

//    private final ArrayList<String> menuItem;    // This will hold your data
//    private final ArrayList<Integer>pictures;
//    private final ArrayList<String> itemPrice;
//    private final ArrayList<String> categories;
//    private final ArrayList<Double> ratings;
    private final List<SingleMenuItem> itemsList;
//    private final int clockIcon;
//    private final int starIcon;
//    private final int leafIcon;


    private LayoutInflater menuInflater;       // This will be the inflater for FoodMenuAdapter
    List<SingleMenuItem> menuItems;


    // FoodMenuAdapter Constructor
    public FoodMenuAdapter(Context context, List <SingleMenuItem> itemsList)
    {
        menuInflater = LayoutInflater.from(context); // Initialize the layout inflator
        this.itemsList = itemsList;

    }

    // Inner class to the FoodMenuAdapter and extends
    public class ContactViewHolder extends RecyclerView.ViewHolder{
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
        // parameter is to associate the ContactViewHolder with its adapter
        public ContactViewHolder(View itemView, FoodMenuAdapter adapter) {
            super(itemView);
            // Initialize the view holder's text view from the XML resources (activity_contact_list.xml)
            // Be sure to cast it to the View type that you need it to be (i.e TextView)
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
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Inflate the layout
        View customView = menuInflater.inflate(R.layout.fragment_foodmenu_single_item, viewGroup, false);
        // Return the new view holder
        return new ContactViewHolder(customView, this);
    }

    // The onBindViewHolder() connects your data to your view holder
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder foodItemViewHolder, int i) {
        String currentContact = itemsList.get(i).getName();     // Hold the current contact name
        String currentItemPrice = Double.toString(itemsList.get(i).getPrice());
        String currentRate = Double.toString(itemsList.get(i).getRating());
        String currentCategory = itemsList.get(i).getCategory().get(0);

        foodItemViewHolder.nameTextView.setText(currentContact); // Set contact name at i position to TextView
        //foodItemViewHolder.foodImage.setImageResource(currentImage);
        foodItemViewHolder.itemPrice.setText(currentItemPrice);
        foodItemViewHolder.itemRate.setText(currentRate);
        foodItemViewHolder.itemCategory.setText(currentCategory);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
