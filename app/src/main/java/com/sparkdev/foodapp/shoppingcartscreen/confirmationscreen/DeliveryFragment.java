package com.sparkdev.foodapp.shoppingcartscreen.confirmationscreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.User;


public class DeliveryFragment extends Fragment {

    EditText addressInput;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);


        //prefill user address
        if(User.currentUser != null && User.currentUser.getAddress() != null)
        {
            EditText text = view.findViewById(R.id.addressInput);
            text.setText(User.currentUser.getAddress());
        }
        return view;
    }


}
