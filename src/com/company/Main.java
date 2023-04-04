package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        String test = "saddsasda";
        List<Integer> customList = new CustomList<>();

        customList.add(2);
        customList.add(7);

        RangePredicate<Integer> predicate = new RangePredicate<>(4,10);

        List<Integer> customList2 = customList.stream().filter(predicate).toList();

        for(Integer element : customList2) {
            System.out.println(element);
        }
//
//        String t1 = "saddsa";
//        Double t2 = 2.0;

        // isAssignableFrom
//        if(t1.getClass().equals(t2.getClass())) {
//
//        }

    }
}