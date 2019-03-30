package com.sparkdev.foodapp.shoppingcartscreen.confirmationscreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sparkdev.foodapp.R;

public class ConfirmationActivity extends AppCompatActivity  {

    private  boolean isDelivery = true;
    private PriceFragment priceFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        String name = "Reiner";

        priceFragment = PriceFragment.newInstance(isDelivery, name);
        FragmentManager manager1 = getSupportFragmentManager();
        manager1.beginTransaction()
                .replace(R.id.priceLayout, priceFragment, priceFragment.getTag())
                .commit();


        Button button = findViewById(R.id.DButton);
        button.setBackgroundColor(getResources().getColor(R.color.btColor));
        button.setTextColor(getResources().getColor(R.color.white));

        DeliveryFragment deliveryFragment = new DeliveryFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, deliveryFragment);
        fragmentTransaction.commit();


    }



    public void ChangeFragment(View view)
    {

        Fragment fragment;

        if (view == findViewById(R.id.DButton))
        {
            Button Dbutton = findViewById(R.id.DButton);
            Dbutton.setBackgroundColor(getResources().getColor(R.color.btColor));
            Dbutton.setTextColor(getResources().getColor(R.color.white));

            Button Tbutton = findViewById(R.id.TObutton);
            Tbutton.setBackgroundColor(getResources().getColor(R.color.white));
            Tbutton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            Tbutton.setBackgroundResource(R.drawable.btn_border);

            fragment = new DeliveryFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentLayout, fragment);
            ft.commit();

            priceFragment.setDelivery(true);

        }

        if (view == findViewById(R.id.TObutton))
        {
            Button Tbutton = findViewById(R.id.TObutton);
            Tbutton.setBackgroundColor(getResources().getColor(R.color.btColor));
            Tbutton.setTextColor(getResources().getColor(R.color.white));

            Button Dbutton = findViewById(R.id.DButton);
            Dbutton.setBackgroundColor(getResources().getColor(R.color.white));
            Dbutton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            Dbutton.setBackgroundResource(R.drawable.btn_border);

            fragment = new TakeoutFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentLayout, fragment);
            ft.commit();

            priceFragment.setDelivery(false);

        }

    }
}
