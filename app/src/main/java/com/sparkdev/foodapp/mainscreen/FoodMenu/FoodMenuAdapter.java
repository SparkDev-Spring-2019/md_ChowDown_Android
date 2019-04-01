package com.sparkdev.foodapp.mainscreen.FoodMenu;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.mainscreen.productpage.ProductPageActivity;
import com.sparkdev.foodapp.models.SingleMenuItem;

import java.util.List;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.ContactViewHolder>{

//    private final ArrayList<String> menuItem;    // This will hold your data
//    private final ArrayList<Integer>pictures;
//    private final ArrayList<String> itemPrice;
//    private final ArrayList<String> categories;
//    private final ArrayList<Double> ratings;
    private final List<SingleMenuItem> itemsList;
    private final Context context;
//    private final int clockIcon;
//    private final int starIcon;
//    private final int leafIcon;


    private LayoutInflater menuInflater;       // This will be the inflater for FoodMenuAdapter



    // FoodMenuAdapter Constructor
    public FoodMenuAdapter(Context context, List <SingleMenuItem> itemsList)
    {
        this.context = context;
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
        public final TextView time;
        public final TextView itemCategory;
        public final ImageView clockPic;
        public final ImageView leafPic;
        public final ImageView starPic;
        final FoodMenuAdapter rowAdapter;
        public final RelativeLayout rowLayout;

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
            time = (TextView) itemView.findViewById(R.id.time_textView);
            rowLayout = (RelativeLayout)itemView.findViewById(R.id.menu_item);

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
        final SingleMenuItem item = itemsList.get(i);
        String currentContact = itemsList.get(i).getName();     // Hold the current contact name
        String currentItemPrice = String.format("%.2f", itemsList.get(i).getPrice());
        String currentRate = String.format("%.1f", itemsList.get(i).getRating());
        String currentCategory = itemsList.get(i).getCategory().get(0);
        String currentTime = String.valueOf(itemsList.get(i).getCompletionTime());
        Boolean isVegan = itemsList.get(i).getIsVegan();

        foodItemViewHolder.nameTextView.setText(currentContact); // Set contact name at i position to TextView
        Glide.with(context).load(itemsList.get(i).getFoodImageUrl()).into(foodItemViewHolder.foodImage);
        foodItemViewHolder.itemPrice.setText("$" + currentItemPrice);
        foodItemViewHolder.itemRate.setText(currentRate);
        foodItemViewHolder.itemCategory.setText(currentCategory);
        foodItemViewHolder.time.setText(currentTime );
        foodItemViewHolder.rowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductPageActivity.class);
                intent.putExtra("menu_item_detail", (Parcelable)item);
                context.startActivity(intent);
            }
        });

        if(!isVegan)
        {
            foodItemViewHolder.leafPic.setVisibility(View.INVISIBLE);
        }
        else{
            foodItemViewHolder.leafPic.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
