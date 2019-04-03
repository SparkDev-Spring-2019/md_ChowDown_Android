package com.sparkdev.foodapp.mainscreen.productpage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.Review;
import com.sparkdev.foodapp.models.SingleMenuItem;
import com.sparkdev.foodapp.models.firebase.FirebaseAdapter;
import com.sparkdev.foodapp.models.firebase.GetMenuItemReviewsCompletionListener;

import java.util.List;


public class ReviewFragment extends Fragment {

    private SingleMenuItem current ;
    private List<Review> reviewsList;
    private  FirebaseAdapter fb;
    private ReviewsAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final  View view = inflater.inflate(R.layout.activity_fragment_list, container, false);

       fb = FirebaseAdapter.getInstance(getActivity());
       fb.getReviews(current, new GetMenuItemReviewsCompletionListener() {
           @Override
           public void onSuccess(List<Review> reviews) {
               reviewsList = reviews;

               if(!reviewsList.isEmpty())
               {
                   RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);
                   listAdapter = new ReviewsAdapter(getActivity(),reviewsList);
                   recyclerView.setAdapter(listAdapter);
                   RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                   ((LinearLayoutManager) layoutManager).setStackFromEnd(true);
                   ((LinearLayoutManager) layoutManager).setReverseLayout(true);
                   recyclerView.setLayoutManager(layoutManager);
                   fb.reviewsListener(current, listAdapter, recyclerView);
               }



           }

           @Override
           public void onFailure() {
               Toast.makeText(getActivity(), "Unable to load list!", Toast.LENGTH_SHORT).show();
           }
       });


        FloatingActionButton fltButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        fltButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openReviewSubmissionPage();
            }
        });



        return view;

    }

    private void openReviewSubmissionPage() {
        Intent intent = new Intent(getActivity(), ReviewSubmissionPage.class);
        intent.putExtra("food_item", (Parcelable)current);
        startActivity(intent);
    }

    public static ReviewFragment newInstance(SingleMenuItem item) {

        Bundle args = new Bundle();
        args.putParcelable("menu_item", (Parcelable)item);
        ReviewFragment fragment = new ReviewFragment();
        fragment.setArguments(args);
        return fragment;
    }


    //initialize food item
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        current = getArguments().getParcelable("menu_item");
    }


}
