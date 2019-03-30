package com.sparkdev.foodapp.mainscreen.productpage;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.StackView;

import com.sparkdev.foodapp.R;

import java.util.ArrayList;


public class ProductPageActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private LinearLayout linearLayout;
    private ViewPager viewPager;

    private static StackView stackView;
    private static ArrayList list;
    private static final Integer[] icons = {R.drawable.picture_1, R.drawable.picture_2, R.drawable.picture_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new OrderFragment(), "Order");
        adapter.AddFragment(new DescriptionFragment(), "Description");
        adapter.AddFragment(new ReviewFragment(), "Review");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        stackView = (StackView) findViewById(R.id.product_stack_view);
        list = new ArrayList();

        for (int i = 0; i < icons.length; i++) {
            list.add(new StackItems("Item " + i, icons[i]));
        }
        StackViewAdapter adapter1 = new StackViewAdapter(this, list);
        stackView.setAdapter(adapter1);
        adapter.notifyDataSetChanged();


    }

}
