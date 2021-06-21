package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class listAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<MenuData> sample;

    public listAdapter(Context context, ArrayList<MenuData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public MenuData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listview_custom, null);

        TextView menuName = (TextView)view.findViewById(R.id.menuName);
        TextView ingredient = (TextView)view.findViewById(R.id.ingredient);

        menuName.setText(sample.get(position).getName());
        ingredient.setText(sample.get(position).ingredient());

        return view;
    }
}
