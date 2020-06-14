package com.example.technology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class DetailActivity extends AppCompatActivity {

    private ImageView Cover;
    private TextView title, price, description;
    String setPrice;
    ViewFlipper imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //declaration of variables in relations to where they should be set in the activity
        imageSlider = findViewById(R.id.imageSlider);
        Cover = findViewById(R.id.ProductImage);
        title = findViewById(R.id.titleProduct);
        price = findViewById(R.id.prices);
        description = findViewById(R.id.description);

        //get item being passed into detail activity
        Intent detailsview = getIntent();
        Technology item = (Technology) detailsview.getSerializableExtra(TechnologyAdapter.TECH_DETAIL_KEY);

        //set values to display components, gets any information from the object by calling its functions
        title.setText(item.getName());
        description.setText(item.getDescription());
        setPrice = item.getPrice();
        setPrice = "$ " + setPrice;
        price.setText(setPrice);
        Cover.setImageResource(item.getImage());
        int images[] = item.getSlide(); // array which gets slider images

        //display images through the image slider function
        for (int image : images) {
            imageSlider(image);
        }
    }

    public void imageSlider(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        imageSlider.addView(imageView);
        imageSlider.setFlipInterval(3000); //3 seconds
        imageSlider.setAutoStart(true); //start image slider automatically
        //animation for image sliding
        imageSlider.setInAnimation(this, android.R.anim.slide_in_left);
        imageSlider.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}

