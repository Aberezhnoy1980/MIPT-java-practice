package ru.aberezhnoy.lesson.collection;

import java.util.HashSet;

public class SetApp {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Petya");
        set.add("Olya");
        set.add("Petya");
        System.out.println(set);
        System.out.println(set.contains("Olya"));
    }
}
