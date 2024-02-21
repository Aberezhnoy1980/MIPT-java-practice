package ru.aberezhnoy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
//        int val = scanner.nextInt();
//        if (val > 10) {
//            System.out.println("More than 10");
//        } else if (val == 10) {
//            System.out.println("Equals 10");
//        } else {
//            System.out.println("Less than 10");
//        }

        int value = scanner.nextInt();

//        switch (value) {
//            case 1 -> System.out.println("1");
//            case 2 -> System.out.println("2");
//            case 3 -> System.out.println("3");
//            default -> System.out.println("?");
//        }

        String str;
//        if (value % 2 == 0) {
//            str = "even";
//        } else {
//            str = "odd";
//        }

        str = value % 2 == 0 ? "even" : "odd";
        System.out.println(str);
    }
}
