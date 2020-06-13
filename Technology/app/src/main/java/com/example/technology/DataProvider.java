package com.example.technology;

import android.content.Intent;

import com.example.technology.R;
import com.example.technology.Technology;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
    static String[] products = {"Blackberry" , "iPhone 4" ,"Google Nexus", "Nokia 7230",
    "OPPO R11", "Sony Xperia", "LG Smart Watch", "MacBook Air", "MackBook Pro", "Apple Watch Series 1"
    ,"Apple Watch Series 3"};
    static String[] prices = {"250","499","285","297","769", "1199", "449", "1949", "2079", "450", "550"};
    static int[] categoryNumbers = {1,1,1,1,1,1,3,2,2,3,3};
    static int[] covers = {R.drawable.blackberry_1, R.drawable.iphone4_1, R.drawable.nexus_1,
    R.drawable.nokia_1, R.drawable.oppor11_1, R.drawable.sony_1, R.drawable.lgwatch_1,
    R.drawable.macbookair_1,R.drawable.macbookpro_1,R.drawable.series1_3, R.drawable.series3_1};

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
