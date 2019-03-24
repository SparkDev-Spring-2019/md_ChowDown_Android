package com.sparkdev.foodapp.shoppingcartscreen.OrderScreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sparkdev.foodapp.R;

import java.util.ArrayList;

public class OrderScreenAdapter extends RecyclerView.Adapter<OrderScreenAdapter.ContactViewHolder>{

    private final ArrayList<String> itemList;    // This will hold your data
    private LayoutInflater contactInflater;       // This will be the inflater for OrderScreenAdapter

    // OrderScreenAdapter Constructor
    public OrderScreenAdapter(Context context, ArrayList<String> contactList) {
        contactInflater = LayoutInflater.from(context); // Initialize the layout inflator
        this.itemList = contactList; // Initialize the arraylist
    }

    // Inner class to the OrderScreenAdapter and extends
    public class ContactViewHolder extends RecyclerView.ViewHolder{
        // The following variables are for the text view and the adapter for each row
        public final TextView nameTextView;
        final OrderScreenAdapter rowAdapter;

        // Constructor where the first parameter is to inflate the layout and the second
        // parameter is to associate the ContactViewHolder with its adapter
        public ContactViewHolder(View itemView, OrderScreenAdapter adapter) {
            super(itemView);
            // Initialize the view holder's text view from the XML resources (activity_order_screen.xml)
            // Be sure to cast it to the View type that you need it to be (i.e TextView)
            nameTextView = (TextView) itemView.findViewById(R.id.foodName);
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
        View customView = contactInflater.inflate(R.layout.single_item, viewGroup, false);
        // Return the new view holder
        return new ContactViewHolder(customView, this);
    }

    // The onBindViewHolder() connects your data to your view holder
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        String currentContact = itemList.get(i);     // Hold the current contact name
        contactViewHolder.nameTextView.setText(currentContact); // Set contact name at i position to TextView
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
