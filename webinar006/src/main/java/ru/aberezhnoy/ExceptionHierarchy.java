package ru.aberezhnoy;

public class ExceptionHierarchy {
    public static void main(String[] args) {
        System.out.println("  -------Throwable-------");
        System.out.println("  ^                     ^");
        System.out.println("  |                     |");
        System.out.println("Error               Exception");
        System.out.println("                        ^");
        System.out.println("                        |");
        System.out.println("                 RuntimeException");
    }
}
