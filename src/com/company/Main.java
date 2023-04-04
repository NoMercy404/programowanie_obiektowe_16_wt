package com.company;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        CustomList<String> customList = new CustomList<>();
        customList.addLast("test");
        customList.addFirst("test2");

        System.out.println(customList.getFirst());
    }
}