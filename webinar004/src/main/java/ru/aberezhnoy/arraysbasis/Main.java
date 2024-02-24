package ru.aberezhnoy.arraysbasis;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 5;
        System.out.println(arr[0]);
        System.out.println(arr[4]);

        arr[1] = 3;
        arr[2] = 15;
        arr[3] = 100;
        arr[4] = 1;
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {5, 3, 15, 100, 1};

        System.out.println(Arrays.toString(arr2));

        System.out.println(arr == arr2);
        System.out.println(arr.equals(arr2));
        System.out.println(Arrays.equals(arr, arr2));

        String[] strings = {"Petya, Olya, Tanya"};

        Singer[] singers = {
                new Singer("Petya", 21),
                new Singer("Olya", 19)
        };


    }
}
