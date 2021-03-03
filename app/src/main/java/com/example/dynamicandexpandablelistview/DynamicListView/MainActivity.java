package com.example.dynamicandexpandablelistview.DynamicListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dynamicandexpandablelistview.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button addFruit;
    private EditText fruitsText;
    ConstraintLayout layout;
    ArrayList fruitsList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        fruitsText = (EditText) findViewById(R.id.fruitField);
        addFruit = (Button) findViewById(R.id.addFruit);
        layout = (ConstraintLayout) findViewById(R.id.main_layout);

         fruitsList= new ArrayList();

         String[] fruit = {"JackFruit", "Mango", "Apple", "Papaya"};

        fruitsList.addAll(Arrays.asList(fruit));

         adapter= new Adapter(this,fruitsList);

         listView.setAdapter(adapter);

         addFruit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 if(fruitsText.getText().equals(null)) {
                     Toast.makeText(MainActivity.this, "Empty field", Toast.LENGTH_SHORT).show();
                 } else {
                     fruitsList.add(fruitsText.getText().toString());
                     adapter.notifyDataSetChanged();
                     Toast.makeText(MainActivity.this, fruitsText.getText().toString() + " added to the list", Toast.LENGTH_SHORT).show();
                     fruitsText.setText("");
                     InputMethodManager manager = (InputMethodManager) getSystemService
                             (Context.INPUT_METHOD_SERVICE);
                     manager.hideSoftInputFromWindow(layout.getWindowToken(), 0);

                     }
             }
         });


            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                    fruitsList.remove(i);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, fruitsList.get(i)+ " removed Successfully", Toast.LENGTH_SHORT).show();

                    return false;
                }
            });

    }
}