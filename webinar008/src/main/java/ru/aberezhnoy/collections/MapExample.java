package ru.aberezhnoy.collections;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "a");

        for (Map.Entry<Integer, String> v : map.entrySet()) {
            System.out.println(v.getKey() + " " + v.getValue());
        }

        System.out.println(map.get(1));
    }
}
