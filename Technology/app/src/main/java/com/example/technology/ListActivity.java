package com.example.technology;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    TechnologyAdapter technologyAdapter;
    List<Technology> techList;
    List<Technology> selectedList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //data gets passed into list activity
        Intent category = getIntent();

        //returns the list of objects with corresponding names etc
        techList = DataProvider.generateData();

        //intent.putExtra passes through the stored string from the previous activity
        //gets the string of category
        String type = category.getStringExtra("category");

        //loops through every object in the list
        for (Technology product : techList){
            String cat = product.getCategory();
            if (type.contains(cat)){        //checks if category equals to the objects category
                selectedList.add(product);  //if true, add into a new list of objects with the same category
            }
        }

        //display all items in the specific list using recyclerview
        RecyclerView recyclerView = findViewById(R.id.RecylcerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //continue making more items in list view until we reach the last one in list
        //sends through to adapter the list of objects in a specific category
        if (selectedList.size() > 0){
            technologyAdapter = new TechnologyAdapter(this, selectedList);
        } else {
            //send through all items in the dataprovider when selected list = 0
            technologyAdapter = new TechnologyAdapter(this, techList);
        }

        //creates recycler view
        recyclerView.setAdapter(technologyAdapter);
    }
}