package com.example.technology;

import android.content.Intent;

import com.example.technology.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class DataProvider {
    static String[] products = {"Iphone XS Max" , "Iphone XR" , "Iphone 6s", "Oppo R11", "Huawei P8", "Apple Watch"};
    static String[] prices = {"1499","1099","2100","699","100","2300"};
    static int[] categoryNumbers = {1,1,2,2,3,3};
    static int[] covers = {R.drawable.phone1, R.drawable.phone2, R.drawable.phone3, R.drawable.phone4, R.drawable.phone5, R.drawable.phone6};

    public static List<Technology> generateData() {
        ArrayList<Technology> techList = new ArrayList<Technology>();
        for (int i = 0; i < products.length; i++) {
            String category = "";
            String productName = products[i];
            String price = prices[i];
            int categoryNumber = categoryNumbers[i];
            int cover = covers[i];
            if (categoryNumber == 1) {
                category = "Phones";
                Technology aPhone = new Technology.Phones(productName, category, cover, price) {
                };
                techList.add(aPhone);
            } else if (categoryNumber == 2){
                category = "Laptops";
                Technology aLaptop = new Technology.Laptops(productName, category, cover, price) {
                };
                techList.add(aLaptop);
            } else if (categoryNumber == 3) {
                category = "Smart Watches";
                Technology aWatch = new Technology.SmartWatches(productName, category, cover, price);
                techList.add(aWatch);
            }
        }

        return techList;
    }
}
