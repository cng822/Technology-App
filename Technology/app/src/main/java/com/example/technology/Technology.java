package com.example.technology;

import java.io.Serializable;

public class Technology implements Serializable {
    protected String productName;
    protected String category;
    protected int image;
    protected String price;
    static int count;

    public Technology(String productName, String category, int image, String price) {
        this.productName = productName;
        this.category = category;
        this.image = image;
        this.price = price;
    }

    public String getName() { return this.productName; }

    public String getCategory() { return this.category; }

    public String getPrice() { return this.price; }

    public int getImage() { return this.image; }

    public int itemViews() { return count++; }


    static class Phones extends Technology {
        public Phones(String productName, String category, int image, String price){
            super(productName, category, image, price);
        }
    }

    static class Laptops extends Technology {
        public Laptops(String productName, String category, int image, String price){
            super(productName, category, image, price);
        }
    }

    static class SmartWatches extends Technology {
        public SmartWatches(String productName, String category, int image, String price){
            super(productName, category, image, price);
        }
    }
}


