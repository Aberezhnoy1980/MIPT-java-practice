package ru.aberezhnoy.xo;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static Scanner sc;
    public static final int SIZE = 3;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = '0';

    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < field.length; i++) {
            Arrays.fill(field[i], EMPTY);
        }

        sc = new Scanner(System.in);
        boolean isCrossTurn = true;

        while (true) {
            System.out.println((isCrossTurn ? "Crosses" : "Zeros") + " turn: ");
            printField(field);
            String input = sc.nextLine();
            String[] tokens = input.split(" ");
            int x = Integer.parseInt(tokens[0]) - 1;
            int y = Integer.parseInt(tokens[1]) - 1;

            if (field[x][y] != EMPTY) {
                continue;
            }
            field[x][y] = isCrossTurn ? CROSS : ZERO;

            if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                System.out.println((isCrossTurn ? "Crosses" : "Zeros") + " wins");
                printField(field);
                break;
            } else {
                isCrossTurn = !isCrossTurn;
            }
        }
    }

    public static boolean isWin(char[][] field, char player) {
        if (field[0][0] == player && field[0][1] == player && field[0][2] == player)
            return true;
        if (field[1][0] == player && field[1][1] == player && field[1][2] == player)
            return true;
        if (field[2][0] == player && field[2][1] == player && field[2][2] == player)
            return true;

        if (field[0][0] == player && field[1][0] == player && field[2][0] == player)
            return true;
        if (field[0][1] == player && field[1][1] == player && field[2][1] == player)
            return true;
        if (field[0][2] == player && field[1][2] == player && field[2][2] == player)
            return true;

        if (field[0][0] == player && field[1][1] == player && field[2][2] == player)
            return true;
        if (field[2][0] == player && field[1][1] == player && field[0][2] == player)
            return true;

        return false;
    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char sell : row) {
                System.out.print(sell + " ");
            }
            System.out.println();
        }
    }
}
