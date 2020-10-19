package com.example.technology;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopViewAdapter extends RecyclerView.Adapter<TopViewAdapter.ViewHolder> {
    public static final String TECH_DETAIL_KEY = "tech";
    private List<Technology> items;
    private Context context;

    // similar to technology adapter but with layout changes to account for horizontal recycler
    // view in main page
    public TopViewAdapter (Context context, List<Technology> objects){
        this.context = context;
        this.items = objects;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_picks, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Technology pickProduct = items.get(position);
        viewHolder.image.setImageResource(pickProduct.getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagepick);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Intent select = new Intent(v.getContext(), DetailActivity.class);
                    select.putExtra(TECH_DETAIL_KEY, items.get(getAdapterPosition()));
                    v.getContext().startActivity(select);
                }
                }
            );
        }
    }
}
