package ru.aberezhnoy.references;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 10;
        double d = 3.5;
        x += 10;
        x--;
        int y = x / 11;

        final ArrayList list = new ArrayList<>();
        list.add("Anya");
        list.add("Petya");
        list.add("Olya");
        System.out.println(list);

        ArrayList list2 = list;
//        list2.remove("Olya");
        ArrayList list3 = new ArrayList<>();
        list3.add("Anya");
        list3.add("Petya");
        list3.add("Olya");
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list == list2);
        System.out.println(list2 == list3); // references
        System.out.println(list2.equals(list3)); // values

        String s = "Hello";
        final Scanner scanner = new Scanner(System.in);

    }
}
