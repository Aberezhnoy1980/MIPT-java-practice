package ru.aberezhnoy;

import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.persist.CustomerRepository;
import ru.aberezhnoy.persist.OperationRepository;
import ru.aberezhnoy.persist.TransactionRepository;
import ru.aberezhnoy.persist.model.CashbackOperation;
import ru.aberezhnoy.persist.model.Customer;
import ru.aberezhnoy.persist.model.LoanOperation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainApp {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        OperationRepository or = Factory.getOperationRepository();
        TransactionRepository<Customer> cr = Factory.getCustomerRepository();

        cr.save(Customer.builder()
                        .setFirstname("Petr")
                        .setLastname("Petrovich")
                        .setSurname("Petrov")
                        .setGender("Male")
                        .setBirthDate("28/11/1979")
                        .setEmail("Petrov_pp@mail.ru")
                        .setPhoneNumber("89994141041")
                        .build())
                .save(Customer.builder()
                        .setFirstname("Ivan")
                        .setLastname("Ivanovich")
                        .setSurname("Ivanov")
                        .setGender("Male")
                        .setBirthDate("29/12/1980")
                        .setEmail("Ivanov_ii@mail.ru")
                        .setPhoneNumber("87774141041")
                        .build())
                .save(Customer.builder()
                        .setFirstname("Elena")
                        .setLastname("Elenovna")
                        .setSurname("Elenova")
                        .setGender("Female")
                        .setBirthDate("23/12/1972")
                        .setEmail("Elenova_ee@mail.ru")
                        .setPhoneNumber("85554141041")
                        .build());

        Customer customer = Customer.builder()
                .setFirstname("Petro")
                .setLastname("Petrovichoff")
                .setSurname("Petrovichenko")
                .setGender("Male")
                .setBirthDate("20/01/2023")
                .setEmail("Petrovichenko_pp@mail.ru")
                .setPhoneNumber("8888888888")
                .build();

        cr.save(customer);

        cr.findAll();

        or.save(new CashbackOperation(LocalDate.of(1980, 12, 29), 200, "Description1"))
                .save(new CashbackOperation(LocalDate.of(1982, 1, 23), 100, "Description2"))
                .save(new LoanOperation(LocalDate.of(2022, 7, 3), 2200, "Description3", 1))
                .save(new CashbackOperation(LocalDate.of(2023, 3, 8), 400, "Description4"))
                .save(new LoanOperation(LocalDate.of(2020, 5, 23), 1000, "Description5", 2));

        or.save(new CashbackOperation("23/12/2019", "500", "Description6"));
        or.save(new CashbackOperation(sc.next(), sc.next(), sc.next()));

        or.findAll();

        or.removeById(1);
        or.removeById(3);
        System.out.println();
        or.findAll();


    }

    private static List<Transaction> getTransactions() {
        return new ArrayList<>(Arrays.asList(
                new Transaction(1, 123.4, LocalDate.of(1980, 01, 01)),
                new Transaction(2, 123.4, LocalDate.of(1980, 02, 01)),
                new Transaction(3, 123.4, LocalDate.of(1980, 03, 01)),
                new Transaction(4, 123.4, LocalDate.of(1980, 04, 01)),
                new Transaction(5, 123.4, LocalDate.of(1980, 05, 01)),
                new Transaction(6, 123.4, LocalDate.of(1980, 06, 01))
        ));
    }

    private static List<Transaction> addTransactions(List<Transaction> transactions) {
        int i = transactions.size() + 1;
        boolean flag = true;
        while (flag) {
            System.out.printf("Please, enter any double amount (use ',' as delimiter) for transaction #%d: ", i);
            double outerAmount = sc.nextDouble();

            System.out.printf("Please, enter any date in format dd/MM/yyyy for transaction #%d: ", i);
            LocalDate outerDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            transactions.add(new Transaction(i, outerAmount, outerDate));
            i++;

            System.out.println("If you want to continue, input \"y\", or text any symbol: ");
            String answer = sc.next();
            if (!answer.equalsIgnoreCase("y")) flag = false;
        }
        return transactions;
    }

    public static void findTransInPeriod(List<Transaction> transactions) {
        System.out.println("Input start date: ");
        LocalDate startDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Input end date: ");
        LocalDate endDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.date().isAfter(startDate) && t.date().isBefore(endDate)) {
                result.add(t);
            }
        }
        System.out.println(result);
    }

    public record Transaction(int id, double amount, LocalDate date) {

        @Override
        public String toString() {
            return String.format("\nTransaction id: %d, amount: %s, date: %s", id, amount, date);
        }
    }
}
