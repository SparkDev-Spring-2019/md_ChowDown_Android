package com.sparkdev.foodapp.mainscreen.productpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sparkdev.foodapp.R;


public class ReviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);

        RecyclerViewAdapter listAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);




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
        startActivity(intent);
    }


}
