package com.sparkdev.foodapp.shoppingcartscreen.OrderScreen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {

  private OrderScreenAdapter mAdapter;

  public SwipeToDeleteCallback(OrderScreenAdapter adapter) {
    super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
    mAdapter = mAdapter;
  }

  @Override
  public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
    return false;
  }

  @Override
  public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    int position = viewHolder.getAdapterPosition();
    mAdapter.deleteView(position);
  }

}
