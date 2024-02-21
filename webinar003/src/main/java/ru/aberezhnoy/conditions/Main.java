package ru.aberezhnoy.conditions;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Hello");

//        int x = prompt();
//        if (x > 0) System.out.println("X is positive");
//        else if (x == 0) System.out.println("x is 0");
//        else System.out.println("X is negative");


//        int y = prompt();
//        if (y >= 2 && y <= 5) System.out.println("All is fine");
//
//        int z = prompt();
//        if (z <= -10 || z >= 10) System.out.println("All is fine");
//
//        int a = prompt();
//        if (a == 100) System.out.println("The number is equal 100");
//
//        String name = "Petya";
//        if (name.equals("Olya")) System.out.println("?");

//        int n = prompt();
//        if (n == 2) {
//            System.out.println("Bad");
//        } else if (n == 3) {
//            System.out.println("Bad again");
//        } else if (n == 4) {
//            System.out.println("satisfactorily");
//        } else if (n == 5) {
//            System.out.println("Perfecto, mlya5!!");
//        } else System.out.println("incorrect assessment");
//
//        switch (n) {
//            case 2 -> System.out.println("Bad");
//            case 3 -> System.out.println("Bad again");
//            case 4 -> System.out.println("satisfactorily");
//            case 5 -> System.out.println("Perfecto!!");
//            default -> System.out.println("incorrect assessment");
//        }

        System.out.println("Bye");

        int b = prompt();
        int c;
        String text;

        if (b > 0) {
            c = 1;
        } else {
            c = -1;
        }
        System.out.println(c);

        System.out.println(text = b > 0 ? "positive" : "negative");
    }

    public static int prompt() {
        System.out.println("Please, enter any number: ");
        return sc.nextInt();
    }
}
