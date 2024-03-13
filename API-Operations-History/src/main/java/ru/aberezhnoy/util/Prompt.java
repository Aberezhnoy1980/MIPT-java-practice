package ru.aberezhnoy.util;

import java.util.Scanner;

public class Prompt {
    public static String prompt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
}
