package com.example.technology;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    List<Technology> searchList;
    TechnologyAdapter adapter;
    public static TextView noResults;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //return to main activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        noResults = (TextView) findViewById(R.id.noResults);
        searchList = DataProvider.generateData();
        Results();
        Intent intent = getIntent();  // data is passed through to searchactivity
        handleIntent(intent);

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        String toSearch;
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
        }
        toSearch = intent.getStringExtra("search"); // receives string stored from intent
        adapter.getFilter().filter(toSearch);   // filters through to see if any results match
    }

    // sets us recycler view so search results are shown
    private void Results() {
        RecyclerView recyclerView = findViewById(R.id.searchRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TechnologyAdapter(this, searchList);
        recyclerView.setAdapter(adapter);
    }
}
