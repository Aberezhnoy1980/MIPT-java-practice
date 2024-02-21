package ru.aberezhnoy;

import java.util.Scanner;

public class CycleApp {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input integer: ");
            int val = scanner.nextInt();

            int count = 0;
            do {
                count++;
                val /= 10;
            } while (val != 0);

//            int count = 1;
//            while (val != 0) {
//                val /= 10;
//                if (val != 0)
//                    count++;
//            }
//            int count;
//            for (count = 1; val != 0; ) {
//                val /= 10;
//                if (val != 0)
//                    count++;
//            }

            System.out.println(count);
        }
    }
}
