package com.example.technology;

import java.util.ArrayList;
import java.util.List;

public class TopViewProvider {

    public static List<Technology> top3(){
       List<Technology> ListOfProducts = new ArrayList<Technology>();
       List<Technology> Top3 =  new ArrayList<>(3);
       ListOfProducts =  DataProvider.generateData();
       for (int i = 0 ; i < 3; i++){
           Top3.add(ListOfProducts.get(i));
           System.out.println(ListOfProducts.get(i).getName());
       }
        return Top3;
    }
}
