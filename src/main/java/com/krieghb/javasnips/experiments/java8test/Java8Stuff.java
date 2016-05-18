package com.krieghb.javasnips.experiments.java8test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krido02 on 5/18/2016.
 *
 *
 */
public class Java8Stuff {


    public static void main (String [] args) {





    }


    public static void tryMap() {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("One", "Hello");
        myMap.put("Two", "There");
        myMap.put("Three", "Everybody");
        myMap.put("Four", "!");


        for (Map.Entry<String, String> myPair : myMap.entrySet()) {
            System.out.println("MY Pair:  " + myPair);
        }
    }



    public static void tryArticle() {
        ArticleTest aTest = new ArticleTest();


    }

}
