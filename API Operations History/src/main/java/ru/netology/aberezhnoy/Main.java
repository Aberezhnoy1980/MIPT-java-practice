package ru.netology.aberezhnoy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        final ArrayList<Transaction> transactions = new ArrayList<>();
        int i = 0;
        while (i != 5) {
            i++;
            System.out.print("Please, enter any integer for id: ");
            int outerId = sc.nextInt();

            System.out.print("Please, enter any double for amount (use ',' as delimiter): ");
            double outerAmount = sc.nextDouble();

            System.out.print("Please, enter any date in format dd/MM/yyyy for date: ");
            LocalDate outerDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            transactions.add(new Transaction(outerId, outerAmount, outerDate));
        }

        System.out.println(transactions);
    }

    public static class Transaction {
        private final int id;
        private final double amount;
        private final LocalDate date;

        public Transaction(int id, double amount, LocalDate date) {
            this.id = id;
            this.amount = amount;
            this.date = date;
        }

        @Override
        public String toString() {
            return String.format("\nTransaction id: %d, amount: %s, date: %s", id, amount, date);
        }
    }

}
