package ru.aberezhnoy.cycles;

public class Main {
    public static void main(String[] args) {
        int x = 0;

        while (x < 3000) {
            x++;
            if (x % 2 == 0) {
                continue;
            }
            if (x > 50) {
                break;
            }
            System.out.println("Hello World!!" + " in " + x + " time");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

//        int y = 100000;
//        do {
//            System.out.println(y);
//        } while (y < 1000);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
    }
}
