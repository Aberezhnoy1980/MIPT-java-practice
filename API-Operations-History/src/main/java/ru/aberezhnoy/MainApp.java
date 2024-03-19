package ru.aberezhnoy;

import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.persist.CashbackOperation;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.LoanOperation;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.presenter.CustomerService;
import ru.aberezhnoy.presenter.OperationService;
import ru.aberezhnoy.view.View;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainApp {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final View view = new View();
        view.run();

//        final CustomerService cs = new CustomerService();
//        final OperationService os = new OperationService();
//        cs.save(Customer.builder()
//                        .setFirstname("Alex")
//                        .setLastname("Aleksandrovich")
//                        .setSurname("Berezhnoy")
//                        .setBirthDate("29/12/1980")
//                        .setPhoneNumber("9994141041")
//                .build());
//
//        System.out.println(cs.findById(1).getPhoneNumber());
//
//        System.out.println(cs.findAll());
//        System.out.println(cs.findById(1));
//        os.save(new CashbackOperation(1, "123000", "test"));
//        System.out.println(os.findById(1));
//
//        cs.findById(1).addOperations(os.findById(1));
//
//        System.out.println("+");
//        System.out.println(cs.findAll());
//        System.out.println(cs.findById(1).getOperations());

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
