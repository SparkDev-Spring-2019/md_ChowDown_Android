package com.sparkdev.foodapp.mainscreen.productpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.Order;
import com.sparkdev.foodapp.models.OrderItem;
import com.sparkdev.foodapp.models.SingleMenuItem;
import com.sparkdev.foodapp.models.User;

import java.util.List;

public class OrderFragment extends Fragment {
    private String size;
    private String quantity;
    private List<OrderItem> orderItems = User.getCurrentOrder();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_order, container, false);

        //set up size selector and listener
        Spinner spinner = (Spinner) view.findViewById(R.id.order_options);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.options, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                size = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //set up size quantity and listener
        Spinner spinner1 = (Spinner) view.findViewById(R.id.order_quantity);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.quantity, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                quantity = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        TextView textView = (TextView) view.findViewById(R.id.top_order_options_tag);
        textView.setText("Order Options");
        textView.setTextSize(24);

        TextView textView1 = (TextView) view.findViewById(R.id.bottom_order_quantity_tag);
        textView1.setText("Quantity");
        textView1.setTextSize(24);


        //add item to cart
        Button orderButton = view.findViewById(R.id.order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingleMenuItem food = ((ProductPageActivity)getActivity()).getCurrentItem();
                OrderItem item = new OrderItem(food, Integer.parseInt(quantity), size);
                orderItems.add(item);
                Toast.makeText(getActivity(), "Added to order!", Toast.LENGTH_SHORT).show();

            }
        });

        return view;

    }


    public String getSize() {
        return size;
    }

    public String getQuantity() {
        return quantity;
    }
}
