package ru.netology.aberezhnoy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int id = sc.nextInt();
        double amount = sc.nextDouble();
        LocalDate transactionDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Transaction id: " + id + ", amount: " + amount + ", date:  " + transactionDate);
    }
}
