package com.sparkdev.foodapp.mainscreen.productpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.SingleMenuItem;

public class DescriptionFragment extends Fragment {

    private TextView descriptionTitle;
    private TextView desciptionText;
    private SingleMenuItem current;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_description, container, false);

        this.current = ((ProductPageActivity)getActivity()).getCurrentItem();

        descriptionTitle = view.findViewById(R.id.description_title);
        descriptionTitle.setText(current.getName());

        desciptionText = view.findViewById(R.id.description_text);
        desciptionText.setText(current.getDescription());

        return view;

    }
}
