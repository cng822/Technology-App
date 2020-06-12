package com.example.technology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DETAIL = "extra_detail";
    private ImageView Cover;
    private TextView title, price, description;
    String setPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView Cover =  findViewById(R.id.ProductImage);
        TextView title = findViewById(R.id.titleProduct);
        TextView price = findViewById(R.id.prices);
        TextView description = findViewById(R.id.description);

        Intent details = getIntent();
        title.setText(details.getStringExtra("name"));
        // need to set this still
//        description.setText(details.getDescription());

        setPrice = details.getStringExtra("price");
        setPrice = "$ " + setPrice;
        price.setText(setPrice);
        Cover.setImageResource(details.getIntExtra("image", 0));
    }


}
