package com.sparkdev.foodapp.shoppingcartscreen.OrderScreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.OrderItem;
import com.sparkdev.foodapp.models.SingleMenuItem;

import java.util.ArrayList;

public class OrderScreenAdapter extends RecyclerView.Adapter<OrderScreenAdapter.OrderViewHolder>{

    private ArrayList<OrderItem> orderList;    //holds list of order items
    private LayoutInflater contactInflater;       // This will be the inflater for OrderScreenAdapter
    private Context context;
    private SingleMenuItem mDeletedItem;
    private Integer mDeletedItemPosition;

    // OrderScreenAdapter Constructor
    public OrderScreenAdapter(Context context, ArrayList<OrderItem> orderList ){
        this.context = context;
        contactInflater = LayoutInflater.from(context); // Initialize the layout inflator
        this.orderList = orderList;
    }

    // Inner class to the OrderScreenAdapter and extends
    public class OrderViewHolder extends RecyclerView.ViewHolder{
        // The following variables are for the text view and the adapter for each row
        public final TextView nameTextView;
        public final TextView quantityTextView;
        public final TextView priceTextView;
        public final TextView sizeTextView;
        public final ImageView imageview;
        final OrderScreenAdapter rowAdapter;

        // Constructor where the first parameter is to inflate the layout and the second
        // parameter is to associate the FoodItemViewHolder with its adapter
        public OrderViewHolder(View itemView, OrderScreenAdapter adapter) {
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
    public OrderViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Inflate the layout
        View customView = contactInflater.inflate(R.layout.order_single_item, viewGroup, false);
        // Return the new view holder
        return new OrderViewHolder(customView, this);
    }

    // The onBindViewHolder() connects your data to your view holder
    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder orderViewHolder, int i) {

        SingleMenuItem foodItem = orderList.get(i).getFoodItem();
        OrderItem orderItem = orderList.get(i);
        //format price to 2 decimal places
        String price = String.format("%.2f", foodItem.getPrice());

        orderViewHolder.nameTextView.setText(foodItem.getName()); // Set contact name at i position to TextView
        Glide.with(context).load(foodItem.getFoodImageUrl()).into(orderViewHolder.imageview);
        orderViewHolder.priceTextView.setText("$" + price);
        orderViewHolder.sizeTextView.setText("Size: " + orderItem.getSize());
        orderViewHolder.quantityTextView.setText("Quantity: " + String.valueOf(orderItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public void deleteView(int position) {
      mDeletedItem = orderList.get(position).getFoodItem();
      mDeletedItemPosition = position;
      orderList.remove(position);
      notifyDataSetChanged();

      // TODO
//      showUndoSnackbar();
    }
}
