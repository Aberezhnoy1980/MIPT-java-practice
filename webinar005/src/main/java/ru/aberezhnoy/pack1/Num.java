package ru.aberezhnoy.pack1;

public class Num {
    public static int num = 12;

    public static void print(int val) {
        System.out.println(num + " int " + val);
    }

    public static void print(double val) {
        System.out.println("double " + val);
    }

    @Override
    public String toString() {
        return String.format("num: %d", num);
    }
}
