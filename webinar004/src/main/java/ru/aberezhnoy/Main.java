package ru.aberezhnoy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int value = sc.nextInt();
//
//        for (int i = 0; i < value; i++) {
//            if (i % 2 == 0) {
//                System.out.println(i + " is even");
//                if (i == 100) break;
//                continue;
//            }
//            System.out.println(i + " is odd");
//        }
//        System.out.println("Cycle finished");

//        int monthNumber = sc.nextInt();
//        String season = "Incorrect value";
//        switch (monthNumber) {
//            case 1, 1, 12: yield "Winnter";
//            case 3, 4, 5: yield "Spring";
//            case 6, 7, 8: yield "Summer";
//            case 9, 10, 11:
//            default:  yield "Autumn";
//        }
//        System.out.println(monthNumber);

        int[] f = new int[10];
        f[0] = 1;
        f[9] = 457;
        String[] strings = new String[3];
        strings[0] = "A";
        strings[1] = "B";
        strings[2] = "C";

        int[] ints = {1, 2, 3, 4, 6, 7, 8, 9};
        int[][] twinArr = new int[3][];
        twinArr[0] = new int[5];
        twinArr[1] = new int[2];
        twinArr[2] = new int[4];

        twinArr[0][1] = 4;
        twinArr[2][3] = 5;

        int[][][] tripleArr = new int[3][][];
        tripleArr[0] = new int[4][];

        int[] arr = {4, 7, 5, 4};
        for (int e : arr) {
            System.out.println(e);
        }

//        System.out.println(Arrays.toString(strings));
//        System.out.println(Arrays.toString(f));
//        System.out.println(Arrays.toString(ints));
//        System.out.println(Arrays.deepToString(twinArr));


    }
}
