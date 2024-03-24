package ru.aberezhnoy.util;

import ru.aberezhnoy.factory.Factory;

import java.util.Scanner;

public class Prompt {
    private static final Scanner sc = Factory.getScanner();
    public static String stringResp(String message) {
        System.out.print(message);
        return sc.next();
    }
    public static int intResp(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    public static long longResp(String message) {
        System.out.print(message);
        return sc.nextLong();
    }
}
