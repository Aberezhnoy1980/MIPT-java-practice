package ru.aberezhnoy.cycles;

import java.util.Scanner;

public class CycleWithPrompt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(getSum(sc));
    }

    public static int getSum(Scanner sc) {
        int sum = 0;
        while (true) {
            System.out.println("Please, enter any integer, or end: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            sum += Integer.parseInt(input);
        }
        return sum;
    }
}
