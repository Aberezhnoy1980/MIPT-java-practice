package ru.aberezhnoy.lesson.tree;

import java.util.Map;
import java.util.TreeMap;

public class TreeApp {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("Petya", 8);
        map.put("Olya", 15);
        int age = map.get("Petya");
        System.out.println(age);
    }
}
