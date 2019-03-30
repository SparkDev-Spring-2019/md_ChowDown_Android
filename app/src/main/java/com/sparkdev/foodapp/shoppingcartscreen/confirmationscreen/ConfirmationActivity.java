package com.sparkdev.foodapp.shoppingcartscreen.confirmationscreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sparkdev.foodapp.R;

public class ConfirmationActivity extends AppCompatActivity  {

    private  boolean isDelivery = true;
    private PriceFragment priceFragment;
    public EditText addressInput;
    public EditText ASInput;
    public EditText zipInput;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        String name = "Reiner";


        //replacing price and place order button container with fragment
        priceFragment = PriceFragment.newInstance(isDelivery, name);
        FragmentManager manager1 = getSupportFragmentManager();
        manager1.beginTransaction()
                .replace(R.id.priceLayout, priceFragment, priceFragment.getTag())
                .commit();


        //setting delivery button to clicked color
        Button button = findViewById(R.id.DButton);
        button.setBackgroundColor(getResources().getColor(R.color.btColor));
        button.setTextColor(getResources().getColor(R.color.white));

        //adding delivery fragment as default in the pop up container
        DeliveryFragment deliveryFragment = new DeliveryFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, deliveryFragment);
        fragmentTransaction.commit();


    }

    public String getAddress()
    {
        addressInput = findViewById(R.id.addressInput);
        String address = addressInput.getText().toString();
        return address;
    }

    public String getZip()
    {
        zipInput = findViewById(R.id.zipInput);
        String zip = zipInput.getText().toString();
        return zip;
    }

    public String getAS()
    {
        ASInput = findViewById(R.id.ASInput);
        String AS = ASInput.getText().toString();
        return AS;
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
