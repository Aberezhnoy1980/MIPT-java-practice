package ru.aberezhnoy.lesson.collection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {
    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        strings.add("Petya");
        strings.add("Olya");
        strings.add("Tanya");

        List<String> strings1 = new ArrayList<>();
        strings1.add("Petya");
        strings1.add("Olya");
        strings1.add("Tanya");

        long startTime = System.currentTimeMillis();
        System.out.println(strings.get(1));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long finishTime = System.currentTimeMillis();
        System.out.printf("Passed %s%n", finishTime - startTime);

        long startTime1 = System.nanoTime();
        System.out.println(strings1.get(1));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long finishTime1 = System.nanoTime();
        System.out.printf("Passed %s%n", finishTime1 - startTime1);
    }
}
