package com.sparkdev.foodapp.shoppingcartscreen.confirmationscreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sparkdev.foodapp.R;

import java.util.ArrayList;


public class TakeoutFragment extends Fragment  {

    String time ;
    String address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_takeout,container,false);
        AddSpinner(view);
        AddSpinner2(view);
        return view;
    }



    public void AddSpinner(View view)
    {
        Spinner spinner = (Spinner) view.findViewById(R.id.timeSpinner);
        ArrayList hours = new ArrayList<String>();
        hours.add("1:00 PM");
        hours.add("2:00 PM");
        hours.add("3:00 PM");
        hours.add("4:00 PM");
        hours.add("5:00 PM");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, hours);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                time  = adapterView.getItemAtPosition(i).toString();
            }
        });
    }

    public void AddSpinner2(View view)
    {
        Spinner spinner = (Spinner) view.findViewById(R.id.locationSpinner);
        ArrayList location = new ArrayList<String>();
        location.add("FIU's Restaurant");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, location);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                address = adapterView.getItemAtPosition(i).toString();
            }
        });
    }

    public String getAddress() {
        return address;
    }

    public String getTime() {
        return time;
    }


}
