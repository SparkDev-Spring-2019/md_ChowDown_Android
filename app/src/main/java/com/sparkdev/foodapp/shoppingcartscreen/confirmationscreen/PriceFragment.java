package com.sparkdev.foodapp.shoppingcartscreen.confirmationscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.Order;
import com.sparkdev.foodapp.models.OrderItem;
import com.sparkdev.foodapp.models.User;
import com.sparkdev.foodapp.models.firebase.FirebaseAdapter;
import com.sparkdev.foodapp.models.firebase.NewOrderCompletionListener;
import com.sparkdev.foodapp.shoppingcartscreen.ThankYouScreen.ThankYouScreen;

import java.util.ArrayList;
import java.util.List;


public class PriceFragment extends Fragment
{
    boolean isDelivery = true;  //default is true
    private final double  fees = 3.00;
    double tipAmount;
    double passedTotal;
    double taxAmount;
    double finalTotal;
    public TextView tipText;
    public TextView totalText;
    public TextView taxText;
    public EditText tipInput;
    public Button orderButton;
    public Button zeroButton;
    public Button tenButton;
    public Button fifteenButton;
    public Button twentyButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_price, container, false);

        //get all the views
        TextView feesText = view.findViewById(R.id.feenumberTextview);
        orderButton = view.findViewById(R.id.orderButton);
        zeroButton = view.findViewById(R.id.zeroButton);
        tenButton = view.findViewById(R.id.tenButton);
        fifteenButton = view.findViewById(R.id.fifteenButton);
        twentyButton = view.findViewById(R.id.twentyButton);
        tipText = view.findViewById(R.id.tipnumberTextview);
        tipInput = view.findViewById(R.id.tipAmountNumber);
        totalText = view.findViewById(R.id.totalnumberTextview);
        taxText = view.findViewById(R.id.taxnumberTextview);

        passedTotal = getActivity().getIntent().getDoubleExtra("total", 00);



        feesText.setText("$" + String.format("%.2f", fees));
        AddTaxesAndFees();

        //place order button
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOrderToFirebase();
            }
        });


        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateTip(v);
            }
        });

        tenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateTip(v);
            }
        });

        fifteenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateTip(v);
            }
        });

        twentyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateTip(v);
            }
        });

        return view;


    }

    private void sendOrderToFirebase() {
        FirebaseAdapter fb = FirebaseAdapter.getInstance(getActivity());
        fb.newOrder(User.getCurrentOrder(), new NewOrderCompletionListener() {
            @Override
            public void onSuccess() {
                Intent intent = new Intent(getActivity(), ThankYouScreen.class);

                if(isDelivery){
                    //get information
                    String address = ((ConfirmationActivity)getActivity()).getDeliveryAddress();

                    //add intent extras
                    intent.putExtra("address", address);
                }

                intent.putExtra("isDelivery", isDelivery);

                //restart order
                User.currentOrder.clear();
                //go to next activity
                startActivity(intent);
            }

            @Override
            public void onFailure() {
                Toast.makeText(getActivity(),"Unable to place your order.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setDelivery(boolean isDelivery)
    {
        this.isDelivery = isDelivery;
    }


    public void AddTaxesAndFees()
    {
        taxAmount = 0.07 * passedTotal;
        finalTotal = passedTotal + taxAmount + fees;
        taxText.setText(String.format("$" + "%.2f", taxAmount));
        totalText.setText((String.format("$" + "%.2f", finalTotal)));
    }

    public double CalculateTip(View view)
    {
        finalTotal = passedTotal + taxAmount + fees;

        if(view == view.findViewById(R.id.tipAmountNumber))
        {
            String n = tipInput.getText().toString();
            tipAmount = Double.parseDouble(String.format("%.2f", n));

            zeroButton.setBackgroundColor(getResources().getColor(R.color.white));
            zeroButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            zeroButton.setBackgroundResource(R.drawable.btn_border);

            tenButton.setBackgroundColor(getResources().getColor(R.color.white));
            tenButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            tenButton.setBackgroundResource(R.drawable.btn_border);

            fifteenButton.setBackgroundColor(getResources().getColor(R.color.white));
            fifteenButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            fifteenButton.setBackgroundResource(R.drawable.btn_border);

            twentyButton.setBackgroundColor(getResources().getColor(R.color.white));
            twentyButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            twentyButton.setBackgroundResource(R.drawable.btn_border);

        }

        if (view == view.findViewById(R.id.zeroButton))
        {
            tipAmount = 0;
            zeroButton.setBackgroundColor(getResources().getColor(R.color.btColor));
            zeroButton.setTextColor(getResources().getColor(R.color.white));

            tenButton.setBackgroundColor(getResources().getColor(R.color.white));
            tenButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            tenButton.setBackgroundResource(R.drawable.btn_border);

            fifteenButton.setBackgroundColor(getResources().getColor(R.color.white));
            fifteenButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            fifteenButton.setBackgroundResource(R.drawable.btn_border);

            twentyButton.setBackgroundColor(getResources().getColor(R.color.white));
            twentyButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            twentyButton.setBackgroundResource(R.drawable.btn_border);

        }

        if (view == view.findViewById(R.id.tenButton))
        {
            tipAmount = passedTotal * .10;
            tenButton.setBackgroundColor(getResources().getColor(R.color.btColor));
            tenButton.setTextColor(getResources().getColor(R.color.white));

            zeroButton.setBackgroundColor(getResources().getColor(R.color.white));
            zeroButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            zeroButton.setBackgroundResource(R.drawable.btn_border);

            fifteenButton.setBackgroundColor(getResources().getColor(R.color.white));
            fifteenButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            fifteenButton.setBackgroundResource(R.drawable.btn_border);

            twentyButton.setBackgroundColor(getResources().getColor(R.color.white));
            twentyButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            twentyButton.setBackgroundResource(R.drawable.btn_border);
        }

        if (view == view.findViewById(R.id.fifteenButton))
        {
            tipAmount = passedTotal * .15;
            fifteenButton.setBackgroundColor(getResources().getColor(R.color.btColor));
            fifteenButton.setTextColor(getResources().getColor(R.color.white));

            tenButton.setBackgroundColor(getResources().getColor(R.color.white));
            tenButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            tenButton.setBackgroundResource(R.drawable.btn_border);

            zeroButton.setBackgroundColor(getResources().getColor(R.color.white));
            zeroButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            zeroButton.setBackgroundResource(R.drawable.btn_border);

            twentyButton.setBackgroundColor(getResources().getColor(R.color.white));
            twentyButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            twentyButton.setBackgroundResource(R.drawable.btn_border);
        }

        if (view == view.findViewById(R.id.twentyButton))
        {
            tipAmount = passedTotal * .20;
            twentyButton.setBackgroundColor(getResources().getColor(R.color.btColor));
            twentyButton.setTextColor(getResources().getColor(R.color.white));

            tenButton.setBackgroundColor(getResources().getColor(R.color.white));
            tenButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            tenButton.setBackgroundResource(R.drawable.btn_border);

            fifteenButton.setBackgroundColor(getResources().getColor(R.color.white));
            fifteenButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            fifteenButton.setBackgroundResource(R.drawable.btn_border);

            zeroButton.setBackgroundColor(getResources().getColor(R.color.white));
            zeroButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            zeroButton.setBackgroundResource(R.drawable.btn_border);
        }

        finalTotal = finalTotal + tipAmount;
        totalText.setText((String.format("$" + "%.2f", finalTotal)));
        tipText.setText("$" + String.format("%.2f", tipAmount));
        tipInput.setText("$" + String.format("%.2f", tipAmount));


        return tipAmount;

    }

}
