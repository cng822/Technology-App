package com.example.technology;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TopViewAdapter picksadapter;
    List<Technology> picks;
    TechnologyAdapter sAdapter;
    List<Technology> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //when the app opens, we want the explode transition
        Explode explode = new Explode();
        getWindow().setEnterTransition(explode);

        //three categories
        final CardView PHCardView = (CardView) findViewById(R.id.phone_view);
        final CardView LTCardView = (CardView) findViewById(R.id.laptops_view);
        final CardView SWCardView = (CardView) findViewById(R.id.watches_view);

        //if click on the specific card/category, start the specific activity
        //Phones
        PHCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phoneIntent = new Intent(getBaseContext(), ListActivity.class);
                phoneIntent.putExtra("category", "Phones");
                startActivity(phoneIntent);
            }
        });

        // Laptops
        LTCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laptopsIntent = new Intent(getBaseContext(), ListActivity.class);
                // sends through a string to the new activity of which category
                laptopsIntent.putExtra("category", "Laptops");

                //TransitionManager.beginDelayedTransition((LTCardView, PHCardView, SWCardView), fade);
                //toggleVisibility(PHCardView, LTCardView, SWCardView);
                startActivity(laptopsIntent);
            }
            //function to make views invisible
            public void toggleVisibility(View... views){
                //for all views, if they are visible, make them invisible
                for (View current:views){
                    if (current.getVisibility() == View.VISIBLE){
                        current.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        // Watches
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

    //find the three top picks/ most expensive items from each category and display them in recyclerview
    private void setUpTopPicks() {

        // finds the layout
        RecyclerView recyclerView = findViewById(R.id.top3);

        // returns an list of the three most expensive dinner
        picks = TopViewProvider.top3();
        recyclerView.setHasFixedSize(true);
        // how the recycler view is displayed / what direction
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        // creates the recycler view
        picksadapter = new TopViewAdapter(this, picks);
        recyclerView.setAdapter(picksadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.searchbar, menu);
        final MenuItem searchItem = menu.findItem(R.id.searchMenuMain);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        //recieves the inputs as the user starts typing
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // when the user presses submit, a string will be sent to the activity that display the searches
                Intent intent = new Intent(getBaseContext(), SearchActivity.class);
                intent.putExtra("search", query);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;

    }



}