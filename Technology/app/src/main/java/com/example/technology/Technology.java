package com.example.technology;

import java.io.Serializable;

public class Technology implements Serializable {
    protected String description;
    protected String productName;
    protected String category;
    protected int image;
    protected String price;
    protected int [] slide;
    static int count;

    //all the data we need for each product in this app
    public Technology(String productName, String category, int image, String price, String description,
                      int [] slide) {
        this.productName = productName;
        this.category = category;
        this.image = image;
        this.price = price;
        this.description = description;
        this.slide= slide;
        count = 0;
    }

    public String getName() { return this.productName; }

    public String getCategory() { return this.category; }

    public String getPrice() { return this.price; }

    public String getDescription() { return this.description; }

    public int [] getSlide() {return this.slide;}

    public int getImage() { return this.image; }

    public int itemViews() { return count++; }

    //child classes of Technology
    static class Phones extends Technology {
        public Phones(String productName, String category, int image, String price, String description,
                      int [] slide){
            super(productName, category, image, price, description, slide);
        }
    }

    static class Laptops extends Technology {
        public Laptops(String productName, String category, int image, String price, String description,
                       int [] slide){
            super(productName, category, image, price, description, slide);
        }
    }

    static class SmartWatches extends Technology {
        public SmartWatches(String productName, String category, int image, String price, String description,
                            int [] slide){
            super(productName, category, image, price, description, slide);
        }
    }
}


