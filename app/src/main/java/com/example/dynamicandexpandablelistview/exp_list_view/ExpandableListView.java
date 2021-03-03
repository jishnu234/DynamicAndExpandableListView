package com.example.dynamicandexpandablelistview.exp_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dynamicandexpandablelistview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListView extends AppCompatActivity {

    android.widget.ExpandableListView listView;
    HashMap<String, ArrayList<String>> listData;
    AdapterExListView adapterExListView;
    ArrayList<String> titleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);

         listView = (android.widget.ExpandableListView) findViewById(R.id.expListView);
         listData=ExpandableListModel.getData();
         titleList = new ArrayList<String>(listData.keySet());
         adapterExListView = new AdapterExListView(this, listData, titleList);

         listView.setAdapter(adapterExListView);

         listView.setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {
             @Override
             public boolean onGroupClick(android.widget.ExpandableListView expandableListView, View view, int i, long l) {
                 Toast.makeText(ExpandableListView.this, titleList.get(i) +" clicked", Toast.LENGTH_SHORT).show();
                 return false;
             }
         });

         listView.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {
             @Override
             public boolean onChildClick(android.widget.ExpandableListView expandableListView, View view, int i, int i1, long l) {
                 Toast.makeText(ExpandableListView.this, listData.get(titleList.get(i)).get(i1)+" clicked", Toast.LENGTH_SHORT).show();

                 return false;
             }
         });



    }
}