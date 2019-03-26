package com.sparkdev.foodapp.shoppingcartscreen.OrderScreen;

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

public class OrderScreenAdapter extends RecyclerView.Adapter<OrderScreenAdapter.ContactViewHolder>{

    private final ArrayList<String> foodName;    // This will hold your data
    private final ArrayList<String> prices;
    private final ArrayList<Integer> images;
    private final ArrayList<String> sizeOfItem;
    private final ArrayList<Integer> quantity;
    private LayoutInflater contactInflater;       // This will be the inflater for OrderScreenAdapter

    // OrderScreenAdapter Constructor
    public OrderScreenAdapter(Context context, ArrayList<Integer> quantity, ArrayList<String> prices,
                              ArrayList<Integer>images, ArrayList<String> sizeOfItem, ArrayList<String> foodItemName) {

        contactInflater = LayoutInflater.from(context); // Initialize the layout inflator
        this.foodName = foodItemName; // Initialize the arraylist
        this.prices = prices;
        this.images = images;
        this.sizeOfItem = sizeOfItem;
        this.quantity = quantity;
    }

    // Inner class to the OrderScreenAdapter and extends
    public class ContactViewHolder extends RecyclerView.ViewHolder{
        // The following variables are for the text view and the adapter for each row
        public final TextView nameTextView;
        public final TextView quantityTextView;
        public final TextView priceTextView;
        public final TextView sizeTextView;
        public final ImageView imageview;
        final OrderScreenAdapter rowAdapter;

        // Constructor where the first parameter is to inflate the layout and the second
        // parameter is to associate the ContactViewHolder with its adapter
        public ContactViewHolder(View itemView, OrderScreenAdapter adapter) {
            super(itemView);
            // Initialize the view holder's text view from the XML resources (activity_order_screen.xml)
            // Be sure to cast it to the View type that you need it to be (i.e TextView)
            nameTextView = (TextView) itemView.findViewById(R.id.foodName);
            quantityTextView = (TextView) itemView.findViewById(R.id.quantity);
            priceTextView = (TextView) itemView.findViewById(R.id.price);
            sizeTextView = (TextView) itemView.findViewById(R.id.size);
            imageview = (ImageView) itemView.findViewById(R.id.foodImage);

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
        View customView = contactInflater.inflate(R.layout.shopping_cart_single_item, viewGroup, false);
        // Return the new view holder
        return new ContactViewHolder(customView, this);
    }

    // The onBindViewHolder() connects your data to your view holder
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {

        contactViewHolder.nameTextView.setText(foodName.get(i)); // Set contact name at i position to TextView
        contactViewHolder.imageview.setImageResource(images.get(i));
        contactViewHolder.sizeTextView.setText("Size: " +sizeOfItem.get(i));
        contactViewHolder.priceTextView.setText(prices.get(i));
        contactViewHolder.quantityTextView.setText("Quantity: " + Integer.toString(quantity.get(i)));
    }

    @Override
    public int getItemCount() {
        return foodName.size();
    }
}
