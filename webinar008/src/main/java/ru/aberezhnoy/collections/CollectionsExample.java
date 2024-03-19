package ru.aberezhnoy.collections;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(1);

        LinkedList<Integer> linkedElements = new LinkedList<>();
        linkedElements.add(7);
        linkedElements.add(12);
        linkedElements.add(1);
        linkedElements.add(5);
        linkedElements.add(2);

        List<Integer> ints = new ArrayList<>(linkedElements);
        System.out.println(ints);

        Integer[] array = ints.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));

        Set<Integer> integers = new HashSet<>(ints);
        System.out.println(integers);
    }
}
