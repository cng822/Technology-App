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
    static String[] prices = {"599","499","285","297","769", "1199", "449", "1949", "2079", "450", "550"};
    static int[] categoryNumbers = {1,1,1,1,1,1,3,2,2,3,3};
    static int[] covers = {R.drawable.blackberry_1, R.drawable.iphone4_1, R.drawable.nexus_1,
    R.drawable.nokia_1, R.drawable.oppor11_1, R.drawable.sony_1, R.drawable.lgwatch_1,
    R.drawable.macbookair_1,R.drawable.macbookpro_1,R.drawable.series1_3, R.drawable.series3_1};
    static String[] descriptions = {
            "The Blackberry 10 has better performance in the same familiar package. A familiar " +
                    "design inclusive of the beloved classic navigation keys and keyboard, with " +
                    "the speed and powerful performance of BlackBerry 10.",
            "The iPhone 4 has a 3.50-inch touchscreen display with a resolution of 640x960 pixels " +
                    "at a pixel density of 326 pixels per inch (ppi). Apple iPhone 4 is powered " +
                    "by an one-core processor. It comes with 512MB of RAM.",
            "The Google Nexus is runs the Android operating system. Google manages the design, " +
                    "development, marketing, and support of this devices, but some development " +
                    "and all manufacturing were carried out by partnering with original equipment " +
                    "manufacturers (OEMs).",
            "The Nokia 7230 is a stylish, well-priced 3G slider phone that has a good quality of " +
                    "preloaded apps and a 3.2MP camera. ",
            "The OPPO R11 showcases groundbreaking dual 20MP with enhanced effects and unprecedented" +
                    "pictorial clarity.",
            "The Sony Xperia is a very capable and good looking phone which provides the user with " +
                    "a great battery life, decent camera and a big screen in an easy to hold body.",
            "The LG Smart Watch has long-lasting battery that ensures  everything you need is " +
                    "always accessible when you need it most. It's dust and water resistant as well.",
            "The 13-inch MacBook Air features 8GB of memory, a fifth-generation Intel Core " +
                    "processor, Thunderbolt 2, great built-in apps and all-day battery life. It’s " +
                    "thin, light and durable enough to take everywhere you go — and powerful " +
                    "enough to do everything once you get there. ",
            "MacBook Pro elevates the notebook to a whole new level of performance and " +
                    "portability. Wherever your ideas take you, you'll get there faster than " +
                    "ever with high-performance processors and memory, advanced graphics, " +
                    "blazing-fast storage and more.",
            "The Apple Watch Series 1",
            "The Apple Watch Series 3"
    };

    public static List<Technology> generateData() {
        ArrayList<Technology> techList = new ArrayList<Technology>();
        for (int i = 0; i < products.length; i++) {
            String category = "";
            String productName = products[i];
            String price = prices[i];
            String description = descriptions[i];
            int categoryNumber = categoryNumbers[i];
            int cover = covers[i];
            if (categoryNumber == 1) {
                category = "Phones";
                Technology aPhone = new Technology.Phones(productName, category, cover, price, description) {
                };
                techList.add(aPhone);
            } else if (categoryNumber == 2){
                category = "Laptops";
                Technology aLaptop = new Technology.Laptops(productName, category, cover, price,description) {
                };
                techList.add(aLaptop);
            } else if (categoryNumber == 3) {
                category = "Smart Watches";
                Technology aWatch = new Technology.SmartWatches(productName, category, cover, price, description);
                techList.add(aWatch);
            }
        }

        return techList;
    }
}
