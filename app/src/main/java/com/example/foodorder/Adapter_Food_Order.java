package com.example.foodorder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter_Food_Order extends BaseAdapter {
    List<food> foodList;

    public Adapter_Food_Order(List<food> foodList) { this.foodList = foodList; }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_food, parent, false);

        food food = foodList.get(position);

        TextView tvNameFood = view.findViewById(R.id.tvNameFood);

        tvNameFood.setText(food.getName() + " (" + String.valueOf(food.getAmount()) + ")");

        return view;
    }
}
