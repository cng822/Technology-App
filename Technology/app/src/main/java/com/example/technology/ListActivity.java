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

        Intent category = getIntent();
        techList = DataProvider.generateData();
        int size = techList.size();
        String type = category.getStringExtra("category");

        for (Technology product : techList){
            String cat = product.getCategory();
            if (type.contains(cat)){
                selectedList.add(product);
            }
        }

        //display all items in the specific list using recyclerview
        RecyclerView recyclerView = findViewById(R.id.RecylcerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        //continue making more items in list view until we reach the last one in list
        if (selectedList.size() > 0){
            technologyAdapter = new TechnologyAdapter(this, selectedList);
        } else {
            technologyAdapter = new TechnologyAdapter(this, techList);
        }

        recyclerView.setAdapter(technologyAdapter);
    }
}