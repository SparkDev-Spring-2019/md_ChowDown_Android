package com.sparkdev.foodapp.mainscreen.productpage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.firebase.FirebaseAdapter;

import java.util.Date;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    FirebaseAdapter firebaseAdapter;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);

//        firebaseAdapter = new FirebaseAdapter.getInstance();

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return ReviewPageData.names.length;
    }


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mItemText;
        private ImageView mItemImage;
        private TextView mReviewText;

        public ListViewHolder(View itemView){
            super(itemView);

            mItemText = (TextView) itemView.findViewById(R.id.item_text);
            mItemImage = (ImageView) itemView.findViewById(R.id.item_image);
            mReviewText = (TextView) itemView.findViewById(R.id.item_review);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){

//            if( != null){
//                mItemText.setText();
//                mItemImage.setImageResource();
//                mReviewText.setText();
//            }

        }

        public void onClick(View view) {

        }

    }
}
