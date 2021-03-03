package com.example.dynamicandexpandablelistview.exp_list_view;

import android.location.Criteria;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpandableListModel {

    public static HashMap<String, ArrayList<String>> getData() {

        ArrayList<String> football = new ArrayList<String>();

        football.add("Argentina");
        football.add("Brazil");
        football.add("France");
        football.add("Italy");

        ArrayList<String> cricket = new ArrayList<String>();

        cricket.add("India");
        cricket.add("Australia");
        cricket.add("SouthAfrica");
        cricket.add("WestIndices");

        HashMap<String,ArrayList<String>> hashMap = new HashMap<>();

        hashMap.put("Football",football);
        hashMap.put("Cricket",cricket);

        return hashMap;
    }
}
