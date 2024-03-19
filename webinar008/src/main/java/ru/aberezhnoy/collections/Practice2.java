package ru.aberezhnoy.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice2 {
    /*
    С помощью Set можно удалить из любой коллекции дублирующиеся элементы.
    Создайте коллекцию с дублирующимися элементами, затем избавьтесь от дублей, применив Set
     */

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(1, 2, 3, 2, 1, 4, 4));
        System.out.println(ints);

        HashSet<Integer> uniqInts = new HashSet<>(ints);
        System.out.println(uniqInts);

        System.out.println(ints.stream().distinct().collect(Collectors.toList()));

        List<Integer> anotherInts = Stream.of(1, 2, 3, 2, 1, 4, 4).distinct().toList();
        System.out.println(anotherInts);
    }
}
