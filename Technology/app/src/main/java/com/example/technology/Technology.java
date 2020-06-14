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

    // functions to get information eg names
    public String getName() { return productName; }

    public String getCategory() { return category; }

    public String getPrice() { return price; }

    public String getDescription() { return description; }

    public int [] getSlide() {return slide;}

    public int getImage() { return image; }

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


