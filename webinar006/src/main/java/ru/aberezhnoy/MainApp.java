package ru.aberezhnoy;

public class MainApp {
    public static void main(String[] args) {
        int val = 5;
        double valD = 4;

        int[] values = new int[3];
        values[0] = 9;

        Point p = new Point();
        p.x = 3;
        p.y = 4;

        Point[] points = new Point[3];
        points[0] = new Point();
        points[1] = new Point();
        points[1].x = 2;
        points[1].y = 7;

    }

    public static class Point {
        int x;
        int y;
    }
}
