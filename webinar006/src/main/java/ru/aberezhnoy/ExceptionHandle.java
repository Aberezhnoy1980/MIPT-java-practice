package ru.aberezhnoy;

import java.util.Scanner;

public class ExceptionHandle {
    public static void main(String[] args) {
        System.out.println("Hello");

        final Scanner scanner = new Scanner(System.in);
        try (scanner) {
            String s = "Hello";
            char c = get10th(s);
            System.out.println("The answer was: " + c);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("ERROR");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("ERROR 2");
        } finally {
            System.out.println("Fuck you bitch");
        }
        System.out.println("Bye");
    }

    public static char get10th(String s) {
        System.out.println("Start extracting the symbol");
        char ch = s.charAt(10);
        System.out.println("extracted symbol");
        return ch;
    }
}
