package com.sparkdev.foodapp.mainscreen.productpage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sparkdev.foodapp.R;

import com.sparkdev.foodapp.models.Review;

import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {

    private Context context;
    private List<Review> reviews;
    private LayoutInflater menuInflater;

    public ReviewsAdapter(Context context, List<Review> reviews)
    {
        this.context = context;
        menuInflater = LayoutInflater.from(context); // Initialize the layout inflator
        this.reviews = reviews;
    }

    //Inner class
    public class ViewHolder extends RecyclerView.ViewHolder {
        final ReviewsAdapter rowAdapter;
        public final TextView name;
        public final TextView comment;

        public ViewHolder(@NonNull View itemView, ReviewsAdapter adapter) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.item_text) ;
            comment = (TextView) itemView.findViewById(R.id.item_review);
            this.rowAdapter = adapter;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Inflate the layout
        View customView = menuInflater.inflate(R.layout.recycler_view_item, viewGroup, false);
        // Return the new view holder
        return new ViewHolder(customView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(reviews.get(i).getReviewerName());
        viewHolder.comment.setText(reviews.get(i).getReviewMsg());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }



}
