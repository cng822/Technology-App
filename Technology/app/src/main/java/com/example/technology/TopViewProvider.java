package com.example.technology;

import java.util.ArrayList;
import java.util.List;

public class TopViewProvider {
    private static int E1, E2, E3;
    public static List<Technology> top3(){
        List<Technology> ListOfProducts;

        // returns a list of all the items in this database
        ListOfProducts =  DataProvider.generateData();
        return sort(ListOfProducts);
    }

    public static List<Technology> sort(List<Technology> items){
        // array size set to prevent any extra items showing in app
        List<Technology> Top3 =  new ArrayList<>(2);
        E1 = 0;
        E2 = 0;
        E3 = 0;

        // loops through all items to find top 3 most expensive items in each category
        for (Technology range: items){

            // converts string to int
            int i=Integer.parseInt(range.getPrice());

            // if i is bigger than the most expensive in phones
            if ((i > E1 ) && range.getCategory() == "Phones"){
                Top3.add(range); // add object
                // if the object is not null, set more expensive object at the position
                if (Top3.size() > 0){
                    Top3.set(0, range);
                }
                E1 = i;
            } else if ((i > E2) && range.getCategory() == "Laptops"){
                Top3.add(range);
                if (Top3.size() > 0){
                    Top3.set(1, range);
                }
                E2 = i; // new expensive value
            } else if ((i > E3) && range.getCategory() == "Smart Watches"){
                Top3.add(range);
                if (Top3.size() > 0){
                    Top3.set(2, range);
                }
                E3 = i;
            }
        }
        return Top3;
    }
}
