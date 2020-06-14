package com.example.technology;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TechnologyAdapter extends RecyclerView.Adapter<TechnologyAdapter.ViewHolder> implements Filterable {
    public static final String TECH_DETAIL_KEY = "tech";
    private List<Technology> tech;
    private Context aContext;
    List<Technology> AllList, searchList;

    public TechnologyAdapter(Context context, List<Technology> objects) {
        this.tech = objects;
        this.aContext = context;
        AllList = new ArrayList<>(tech);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(aContext).inflate(R.layout.activity_list__view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Technology currentProduct = tech.get(position);
        viewHolder.Title.setText(currentProduct.getName());
        viewHolder.Cover.setImageResource(currentProduct.getImage());

    }

    @Override
    public int getItemCount() {
        return tech.size();
    }

    @Override
    public Filter getFilter() {
        return FilterResults;
    }

    private Filter FilterResults = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Technology> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(AllList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Technology item : AllList) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            tech.clear();
            tech.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Cover;
        TextView Title;


        public ViewHolder(@NonNull View item) {
            super(item);
            Cover = item.findViewById(R.id.ivCover);
            Title = item.findViewById(R.id.tvTitle);

            item.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent select = new Intent(v.getContext(), DetailActivity.class);
                                            select.putExtra(TECH_DETAIL_KEY, tech.get(getAdapterPosition()));
                                            v.getContext().startActivity(select);
                                        }

                                    }
            );

        }
    }
}


