package ru.aberezhnoy.multyarr;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        int[] arr = new int[5];

        int[][] arr2 = new int[3][5];
        int[][] arr3 = {
                {1},
                {22, 222},
                {333, 345, 478}
        };

        printArray(arr2);
        printArray(arr3);


//        arr2[0] = new int[1];
//        arr2[1] = new int[4];
//        arr2[2] = new int[2];

        arr2[1][3] = 15;

        System.out.println(Arrays.deepToString(arr2));
        System.out.println(Arrays.deepToString(arr3));

        int[][][] arr4 = new int[10][20][5];


    }


    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
