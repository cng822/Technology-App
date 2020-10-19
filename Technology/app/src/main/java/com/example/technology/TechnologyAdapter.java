package com.example.technology;


import android.content.Context;
import android.content.Intent;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TechnologyAdapter extends RecyclerView.Adapter<TechnologyAdapter.ViewHolder> implements Filterable {
    public static final String TECH_DETAIL_KEY = "tech";
    private List<Technology> tech;
    private Context aContext;
    List<Technology> AllList;

    //sets constructors
    public TechnologyAdapter(Context context, List<Technology> objects) {
        this.tech = objects;
        this.aContext = context;
        AllList = new ArrayList<>(tech);

    }

    @NonNull
    @Override
    // initialises the viewholder and displays in into our app
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(aContext).inflate(R.layout.activity_list__view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //passes the object's data in the viewholder
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // finds the position of the viewholder
        Technology currentProduct = tech.get(position);
        viewHolder.Title.setText(currentProduct.getName());
        viewHolder.Cover.setImageResource(currentProduct.getImage());

    }

    @Override
    // size of items we want to display
    public int getItemCount() {
        return tech.size();
    }

    @Override
    // returns search results
    public Filter getFilter() {
        return FilterResults;
    }

    // function to filter our results via string user submits
    private Filter FilterResults = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Technology> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(AllList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim(); // sets it to lowercase and to string
                for (Technology item : AllList) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item); // if item equals to filtering string then add to list
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList; // stores results
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            tech.clear(); // clears current list
            tech.addAll((List) results.values);   // add all of the matching items into the list
            if (tech.isEmpty()){
                //if search results are empty, make "No Results Found" textview visible
                SearchActivity.noResults.setVisibility(View.VISIBLE);
            } else {
                // if it is not empty then text view does not appear
                SearchActivity.noResults.setVisibility(View.GONE);
            }
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView Cover;
        TextView Title;

        public ViewHolder(@NonNull final View item) {
            super(item);
            // set names for corresponding ids in the app;
            Cover = item.findViewById(R.id.ivCover);
            Title = item.findViewById(R.id.tvTitle);

            // when clicked
            item.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            // creates a new intent which passes through to DetailActivity
                                            Intent select = new Intent(v.getContext(), DetailActivity.class);
                                            TransitionManager.beginDelayedTransition((ViewGroup) item, new Slide());
                                            // find position in the adapter and sends the data through
                                            select.putExtra(TECH_DETAIL_KEY, tech.get(getAdapterPosition()));
                                            v.getContext().startActivity(select);
                                        }
                                    }
            );

        }
    }
}


