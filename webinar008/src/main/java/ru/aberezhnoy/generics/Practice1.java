package ru.aberezhnoy.generics;

import java.util.Arrays;
import java.util.List;

public class Practice1 {
    /* Напишите метод sumOfList, который подсчитывает
    сумму чисел в переданном списке. Используйте ограничение сверху */
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));
        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
    }

    private static <T extends Number> double sumOfList(List<T> list) {
        double sum = 0;
        for (T e : list)
            sum += e.doubleValue();
        return sum;
    }
}
