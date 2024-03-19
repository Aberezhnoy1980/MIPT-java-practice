package ru.aberezhnoy.lesson.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Petya", 8);
        hashMap.put("Tanya", 15);
        int age = hashMap.get("Tanya");
        System.out.println(age);

        for (String key : hashMap.keySet()) {
            int value = hashMap.get(key);
            System.out.println(key + " : " + value);
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.printf("key: %s, value: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
