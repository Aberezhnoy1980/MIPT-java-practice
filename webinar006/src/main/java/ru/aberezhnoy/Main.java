package ru.aberezhnoy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();

        try {
            if (val < 0) {
                throw new IllegalArgumentException("Age can't be negative");
            }
        } catch (IllegalArgumentException exception) {
            throw new RuntimeException("Something went wrong", exception);
        }
//        method();
    }

    private static void method() {
        byte[] bytesForWrite = "text text text".getBytes();

        try (OutputStream os = new FileOutputStream("webinar006/src/main/java/ru/aberezhnoy/output.file")) {
            os.write(bytesForWrite);
        } catch (IOException e) {
            System.out.println("File not saved " + e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("End");
    }
}
