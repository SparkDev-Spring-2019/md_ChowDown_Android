package com.sparkdev.foodapp.shoppingcartscreen.confirmationscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.shoppingcartscreen.ThankYouScreen.ThankYouScreen;


public class PriceFragment extends Fragment
{
    boolean isDelivery ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_price, container, false);
        Button button = view.findViewById(R.id.orderButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThankYouScreen.class);
                Bundle args = getArguments();

                String name = args.getString("name");
                intent.putExtra("isDelivery", isDelivery);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        return view;


    }

    public void setDelivery(boolean isDelivery)
    {
        this.isDelivery = isDelivery;
    }

    public static PriceFragment newInstance(boolean isDelivery, String name) {
        PriceFragment f = new PriceFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putBoolean("isDelivery", isDelivery);
        args.putString("name", name);

        f.setArguments(args);
        return f;
    }





}
