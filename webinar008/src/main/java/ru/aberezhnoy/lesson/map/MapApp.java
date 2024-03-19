package ru.aberezhnoy.lesson.map;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapApp {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("Petya", "Olya", "Tanya"));

//        String name = strings.get(1);
//        strings.set(1, "Kolya");
//
//        Map<Integer, String> names = new HashMap<>();
//        for (int i = 0; i < strings.size(); i++) {
//            names.put(i + 1, strings.get(i));
//        }
//
//        for (Map.Entry<Integer, String> record : names.entrySet()) {
//            System.out.printf("id: %d, name: %s%n", record.getKey(), record.getValue());
//        }

        final MyMap<String, UserInfo> map = new MyMap<>();
        map.put(strings.get(0), new UserInfo("Petya", 23));
        map.put(strings.get(1), new UserInfo("Olya", 45));
        map.put(strings.get(2), new UserInfo("Tanya-shmara", 19));

        System.out.println(map);
        map.print();


    }
}
