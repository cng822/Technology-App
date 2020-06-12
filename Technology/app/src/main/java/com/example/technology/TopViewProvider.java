package com.example.technology;

import java.util.ArrayList;
import java.util.List;

public class TopViewProvider {

    public static List<Technology> top3(){
       List<Technology> ListOfProducts = new ArrayList<Technology>();
       List<Technology> Top3 =  new ArrayList<>(3);
       ListOfProducts =  DataProvider.generateData();

       // TopViews(ListOfProducts);
       for (int i = 0 ; i < 3; i++){
           Top3.add(ListOfProducts.get(i));
       }
        return Top3;
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
}
