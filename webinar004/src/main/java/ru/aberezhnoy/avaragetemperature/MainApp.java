package ru.aberezhnoy.avaragetemperature;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int[] temperatures = new int[30];
        boolean[] isFilled = new boolean[temperatures.length];

        while (true) {
            System.out.println("Please, input two integers: date and temperature");
            String input = sc.nextLine();
            if ("end".equalsIgnoreCase(input)) {
                break;
            }
            String[] tokens = input.split(" ");
            int day = Integer.parseInt(tokens[0]) - 1;
            int t = Integer.parseInt(tokens[1]);

            temperatures[day] = t;
            isFilled[day] = true;

            double sum = 0;
            for (int tt : temperatures) {
                sum += tt;
            }

            int cnt = 0;
            for (boolean b : isFilled) {
                if (b) {
                    cnt++;
                }
            }
            double avgTemp = sum / cnt;
            System.out.println("Average temperature is: " + avgTemp);
        }
    }
}
