package com.example.dynamicandexpandablelistview.exp_list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.dynamicandexpandablelistview.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AdapterExListView extends BaseExpandableListAdapter {


    HashMap<String, ArrayList<String>> hashMap;
    ArrayList<String> title;
    Context context;

    public AdapterExListView(Context context, HashMap<String,ArrayList<String>> hashMap,
                             ArrayList<String> title) {
        this.context = context;
        this.hashMap = hashMap;
        this.title = title;


    }

    @Override
    public int getGroupCount() {
        return title.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return hashMap.get(title.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return title.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return hashMap.get(title.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.exp_list_header, null);
        if(view != null) {
            TextView textTitle = view.findViewById(R.id.expListTitleTv);
            textTitle.setText(getGroup(i).toString());
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.exp_list_child, null);

        if(view != null) {
            TextView textChild = view.findViewById(R.id.expListChildTv);
            textChild.setText(getChild(i,i1).toString());
        }

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
