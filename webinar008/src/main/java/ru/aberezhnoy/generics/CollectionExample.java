package ru.aberezhnoy.generics;

import java.util.ArrayList;
import java.util.List;

public class CollectionExample {
    public static void main(String[] args) {
        int i = 8;
        double d = 4.0;
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 5));
        List<Double> doubles = new ArrayList<>(List.of(1.4, 2.6, 3.6, 5.234));
        someMethod(i);
        someMethod(d);
        someMethod(integers);
        someMethod(doubles);
    }

    public static void someMethod(Number n) {
        System.out.println(n);
    }

    public static void someMethod(List<? extends Number> list) {
        System.out.println(list);
    }
}
