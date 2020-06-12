package com.example.technology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DETAIL = "extra_detail";
    private ImageView Cover;
    private TextView title, price, description;
    String setPrice;
    ViewFlipper imageSlider;
    Button next;
    Button back;
    int images[] = {R.drawable.phone1, R.drawable.phone2, R.drawable.phone3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageSlider = findViewById(R.id.imageSlider);
        next = (Button) findViewById(R.id.left);
        back = (Button) findViewById(R.id.right);

        for (int image:images){
            imageSlider(image);
        }

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

    public void imageSlider (int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        imageSlider.addView(imageView);
        imageSlider.setFlipInterval(3000); //3 seconds
        imageSlider.setAutoStart(true);
        //animation
        imageSlider.setInAnimation(this, android.R.anim.slide_in_left);
        imageSlider.setOutAnimation(this, android.R.anim.slide_out_right);
    }


}
