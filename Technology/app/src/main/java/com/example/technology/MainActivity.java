package com.example.technology;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.technology.TopViewProvider.top3;

public class MainActivity extends AppCompatActivity {
    TopViewAdapter picksadapter;
    List<Technology> picks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView PHCardView = (CardView) findViewById(R.id.phone_view);
        PHCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phoneIntent = new Intent(getBaseContext(), ListActivity.class);
                phoneIntent.putExtra("category", "Phones");
                startActivity(phoneIntent);
            }
        });
        CardView LTCardView = (CardView) findViewById(R.id.laptops_view);
        LTCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laptopsIntent = new Intent(getBaseContext(), ListActivity.class);
                laptopsIntent.putExtra("category", "Laptops");
                startActivity(laptopsIntent);
            }
        });
        CardView SWCardView = (CardView) findViewById(R.id.watches_view);
        SWCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent watchesIntent = new Intent(getBaseContext(), ListActivity.class);
                watchesIntent.putExtra("category", "Smart Watches");
                startActivity(watchesIntent);
            }
        });

        setUpTopPicks();
    }


    private void setUpTopPicks() {
        RecyclerView recyclerView = findViewById(R.id.top3);
        picks = TopViewProvider.top3();
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        picksadapter = new TopViewAdapter(this, picks);
        recyclerView.setAdapter(picksadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchbar, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.searchMenu).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                searchadapter.getFilter().filter(newText);
//                return false;
//            }
//        });
        return true;
    }

}