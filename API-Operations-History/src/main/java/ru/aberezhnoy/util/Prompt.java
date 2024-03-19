package ru.aberezhnoy.util;

import java.util.Scanner;

public class Prompt {
    public static String prompt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.next();
    }
    public static int prompt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
