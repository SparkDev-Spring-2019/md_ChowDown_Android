package com.sparkdev.foodapp.mainscreen.productpage;
import com.sparkdev.foodapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class StackViewAdapter extends BaseAdapter {

    ArrayList <StackItems> arrayList;
    LayoutInflater inflater;
    ViewHolder holder = null;

    public StackViewAdapter(Context context, ArrayList arrayList) {
        this.arrayList = arrayList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public StackItems getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        if (view == null) {
            view = inflater.inflate(R.layout.stackview_items, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) view.findViewById(R.id.stackview_image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.image.setBackgroundResource(arrayList.get(pos).getImage());

        return view;
    }

    public class ViewHolder {
        ImageView image;
    }

}
