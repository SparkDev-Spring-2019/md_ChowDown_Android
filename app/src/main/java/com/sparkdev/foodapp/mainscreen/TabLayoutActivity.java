package com.sparkdev.foodapp.mainscreen;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.MenuCategory;
import com.sparkdev.foodapp.models.firebase.FirebaseAPI;
import com.sparkdev.foodapp.models.firebase.foodMenuInterface.GetMenuCategoriesCompletionListener;

import java.util.ArrayList;
import java.util.List;


public class TabLayoutActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private static FirebaseAPI firebaseAPI;
    private List<MenuCategory> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_draw);
        firebaseAPI = FirebaseAPI.getInstance(this);
        firebaseAPI.getMenuCategories(new GetMenuCategoriesCompletionListener() {
            @Override
            public void onSuccess(List<MenuCategory> menuCategories) {

                System.out.println("TAB MENU!!!!!" + menuCategories.size());
                System.out.println("FIRST ITEM" + menuCategories.get(0).getCategoryId());

                for(int i = 0; i < menuCategories.size(); i++) {
                    System.out.println(menuCategories.get(i).getCategoryId());
                    categories.add(menuCategories.get(i));
                    System.out.println(categories.size());
                    System.out.println(categories.get(i).getCategoryId());
                }
            }

            @Override
            public void onFailure() {

            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);


       ActionBar actionbar = getSupportActionBar();
       actionbar.setDisplayHomeAsUpEnabled(true);
       actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
       

       // Get the ViewPager and set it's PagerAdapter so that it can display items
        MainscreenFragmentPagerAdapter pagerAdapter = new MainscreenFragmentPagerAdapter(getSupportFragmentManager(),
                TabLayoutActivity.this, categories);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        pagerAdapter.notifyDataSetChanged();

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}