package com.sparkdev.foodapp.mainscreen;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sparkdev.foodapp.models.MenuCategory;

import java.util.List;

public class MainscreenFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<MenuCategory> tabTitles;
    private Context context;


    public MainscreenFragmentPagerAdapter(FragmentManager fm, Context context, List<MenuCategory> tabTitles) {
        super(fm);
        this.context = context;
        this.tabTitles = tabTitles;
    }

    @Override
    public int getCount() {
        return tabTitles.size();
    }

    @Override
    public Fragment getItem(int position) {
        return FoodMenuFragment.newInstance(tabTitles.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles.get(position).getCategoryId();
    }


}