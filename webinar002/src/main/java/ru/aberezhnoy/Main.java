package ru.aberezhnoy;

public class Main {
    public static void main(String[] args) {
        double dMax = Double.MAX_VALUE;
        double dMin = Double.MIN_VALUE;

        System.out.println(dMax == dMin * -1);

        double d = Math.sqrt(5);
        double dPow = d * d;

        System.out.println(d == 5);
    }
}
