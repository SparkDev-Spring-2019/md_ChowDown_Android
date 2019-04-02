package com.sparkdev.foodapp.mainscreen.productpage;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.Review;
import com.sparkdev.foodapp.models.SingleMenuItem;
import com.sparkdev.foodapp.models.firebase.FirebaseAdapter;
import com.sparkdev.foodapp.models.firebase.GetMenuItemReviewsCompletionListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class ProductPageActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private LinearLayout linearLayout;
    private ViewPager viewPager;


    private static ImageView ImageView;
    private static ArrayList list;
    private static final Integer[] icons = {R.drawable.picture_1, R.drawable.picture_2, R.drawable.picture_3};
    private Bundle data;
    private SingleMenuItem current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        data = getIntent().getExtras();
        current = (SingleMenuItem)data.getParcelable("menu_item_detail");

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new OrderFragment(), "Order");
        adapter.AddFragment(new DescriptionFragment(), "Description");
        adapter.AddFragment(ReviewFragment.newInstance(current), "Review");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        ImageView = (android.widget.ImageView) findViewById(R.id.product_stack_view);
        Glide.with(this).load(current.getFoodImageUrl()).into(ImageView);



    }

    public SingleMenuItem getCurrentItem()
    {
        return current;
    }





}
