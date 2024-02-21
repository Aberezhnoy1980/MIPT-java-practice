package ru.aberezhnoy.reals;

public class Main {
    public static void main(String[] args) {
        double d1 = 0.3 + 0.3 + 0.3;
        double d2 = 0.9;
        System.out.println(d1 == d2);
        System.out.println(d1);
        System.out.println(d2);

        if (Math.abs(d2 - d1) < 0.00000001) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

        int x = 5;
        int y = 0;
//        System.out.println(x / y);

        double xd = 5;
        double yd = 0;
        System.out.println(xd / yd);

        double d10 = 5 / yd;
        double d11 = 4 / yd;
        System.out.println(d10 - d11);


    }
}
