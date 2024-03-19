package ru.aberezhnoy.lesson.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hierarchy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Petya");
        list.add("Olya");
        list.add("Tanya");

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        for (String s : list) {
            System.out.println(s);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
