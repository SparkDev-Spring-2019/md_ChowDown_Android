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

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.ContactViewHolder>{

    private final ArrayList<String> menuItem;    // This will hold your data
    private final ArrayList<Integer>pictures;
    private LayoutInflater menuInflater;       // This will be the inflater for FoodMenuAdapter

    // FoodMenuAdapter Constructor
    public FoodMenuAdapter(Context context, ArrayList<String> foodItem, ArrayList<Integer> pictures) {
        menuInflater = LayoutInflater.from(context); // Initialize the layout inflator
        this.menuItem = foodItem; // Initialize the arraylist
        this.pictures = pictures;
    }

    // Inner class to the FoodMenuAdapter and extends
    public class ContactViewHolder extends RecyclerView.ViewHolder{
        // The following variables are for the text view and the adapter for each row
        public final TextView nameTextView;
        public final ImageView foodImage;
        final FoodMenuAdapter rowAdapter;

        // Constructor where the first parameter is to inflate the layout and the second
        // parameter is to associate the ContactViewHolder with its adapter
        public ContactViewHolder(View itemView, FoodMenuAdapter adapter) {
            super(itemView);
            // Initialize the view holder's text view from the XML resources (activity_contact_list.xml)
            // Be sure to cast it to the View type that you need it to be (i.e TextView)
            nameTextView = (TextView) itemView.findViewById(R.id.menuItem_name);
            foodImage  = (ImageView) itemView.findViewById(R.id.foodItem_image) ;
            // Set up the adapter
            this.rowAdapter = adapter;
        }
    }


    // The onCreateViewHolder() method is very similar to the onCreate() method. In this method,
    // the LAYOUT will be inflated and it will return a view holder with the specified layout
    // and the corresponding adapter
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Inflate the layout
        View customView = menuInflater.inflate(R.layout.single_contact_layout, viewGroup, false);
        // Return the new view holder
        return new ContactViewHolder(customView, this);
    }

    // The onBindViewHolder() connects your data to your view holder
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        String currentContact = menuItem.get(i);     // Hold the current contact name
        int currentImage = pictures.get(i);

        contactViewHolder.nameTextView.setText(currentContact); // Set contact name at i position to TextView
        contactViewHolder.foodImage.setImageResource(currentImage);
    }

    @Override
    public int getItemCount() {
        return menuItem.size();
    }
}
