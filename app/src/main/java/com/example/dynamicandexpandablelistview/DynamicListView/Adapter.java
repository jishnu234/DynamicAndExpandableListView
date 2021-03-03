package com.example.dynamicandexpandablelistview.DynamicListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dynamicandexpandablelistview.R;

import java.util.ArrayList;


import static com.example.dynamicandexpandablelistview.R.layout.dynamic_list_layout;

public class Adapter extends BaseAdapter {

    Context context;
    ArrayList dataSet;

    public Adapter(Context context, ArrayList dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(dynamic_list_layout,
                null);

        TextView textView = view.findViewById(R.id.listTextView);
        textView.setText(dataSet.get(i).toString());

        return view;
    }
}
