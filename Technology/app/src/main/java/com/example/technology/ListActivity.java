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

        RecyclerView recyclerView = findViewById(R.id.RecylcerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       if (selectedList.size() > 0){
           technologyAdapter = new TechnologyAdapter(this, selectedList);
       } else {
            technologyAdapter = new TechnologyAdapter(this, techList);
       }

        recyclerView.setAdapter(technologyAdapter);
    }
}