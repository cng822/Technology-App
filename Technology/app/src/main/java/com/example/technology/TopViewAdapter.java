package com.example.technology;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopViewAdapter extends RecyclerView.Adapter<TopViewAdapter.ViewHolder> {
    private List<Technology> items;
    private Context context;

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
        viewHolder.top.setImageResource(pickProduct.getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

//    public static List<Technology> TopViews (List<Technology> items) {
//        List<Technology> Top3 =  new ArrayList<>(3);
//        HashMap<String, Integer> productAndView = new HashMap<String, Integer>();
//        int[] mostViewed = new int[3];
//        int max = 0;
//        boolean updated = false;
//        for (Technology product : items){
//            productAndView.put(product.getName(), product.itemViews());
//        }
//
//        for (Technology product : items) {
//            for (int i = 0; i < mostViewed.length; i++) {
//                if (!updated) {
//                    if (product.itemViews() > mostViewed[i] || product.itemViews() == max) {
//                        updated = true;
//                        mostViewed[i] = product.itemViews();
//                        if (product.itemViews() > max) {
//                            max = product.itemViews();
//                        }
//                    }
//                }
//            }
//        }
//
//        return Top3;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView top;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            top = itemView.findViewById(R.id.picks);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Intent select = new Intent(v.getContext(), DetailActivity.class);
                    select.putExtra("name", items.get(getAdapterPosition()).getName());
                    select.putExtra("image", items.get(getAdapterPosition()).getImage());
                    select.putExtra("price", items.get(getAdapterPosition()).getPrice());
                    v.getContext().startActivity(select);
                }
                }
            );
        }
    }
}
