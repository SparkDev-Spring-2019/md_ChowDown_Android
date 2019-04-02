package com.sparkdev.foodapp.mainscreen.productpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkdev.foodapp.R;

public class OrderFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_order, container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.order_options);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.options, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner1 = (Spinner) view.findViewById(R.id.order_quantity);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.quantity, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        TextView textView = (TextView) view.findViewById(R.id.top_order_options_tag);
        textView.setText("Order Options");
        textView.setTextSize(24);

        TextView textView1 = (TextView) view.findViewById(R.id.bottom_order_quantity_tag);
        textView1.setText("Quantity");
        textView1.setTextSize(24);

        return view;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){

        }else{
            String selectedOption = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), selectedOption, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
