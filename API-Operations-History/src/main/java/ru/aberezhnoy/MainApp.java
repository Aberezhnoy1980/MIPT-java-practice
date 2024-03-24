package ru.aberezhnoy;

import ru.aberezhnoy.model.persist.CashbackOperation;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.LoanOperation;
import ru.aberezhnoy.presenter.ArrayStatementService;
import ru.aberezhnoy.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
//        start();
        Presenter p = Presenter.getInstance();
        ArrayStatementService ass = new ArrayStatementService();
        p.saveCustomer(Customer.builder()
                .setFirstname("Alex")
                .setLastname("Aleksandrovich")
                .setSurname("Berezhnoy")
                .setBirthDate("29/12/1980")
                .build());
        p.saveCustomer(Customer.builder()
                .setFirstname("Sergey")
                .setLastname("Vladimirovich")
                .setSurname("Ermakov")
                .setBirthDate("17/08/1981")
                .build());
        p.saveCustomer(Customer.builder()
                .setFirstname("Elena")
                .setLastname("Anatolyevna")
                .setSurname("Berezhnaya")
                .setBirthDate("23/12/1972")
                .build());

        p.saveOperation(new CashbackOperation(1, "123", "Desc1"));
        p.saveOperation(new LoanOperation(1, "123000", "Desc2", "1"));

        p.saveOperation(new CashbackOperation(2, "12", "Desc3"));
        p.saveOperation(new LoanOperation(2, "200000", "Desc4", "2"));
        p.saveOperation(new CashbackOperation(2, "34", "Desc5"));

        p.saveOperation(new LoanOperation(3, "1500000", "Desc6", "3"));
        p.saveOperation(new CashbackOperation(3, "150", "Desc7"));
        p.saveOperation(new LoanOperation(3, "25000", "Desc8", "4"));
        p.saveOperation(new CashbackOperation(3, "3", "Desc9"));

        System.out.println(p.getCustomerService().findAll());

//        System.out.println("Show customers");
//        p.showAllCustomers();
//        System.out.println("Show operations");
//        p.showAllOperations();
//        System.out.println("Show operations by customer with id 1");
//        p.showOperationsByCustomer(1);
//        System.out.println("Show operations by customer with id 2");
//        p.showOperationsByCustomer(2);
//        System.out.println("Show operations by customer with id 3");
//        p.showOperationsByCustomer(3);
//        System.out.println(Arrays.toString(ass.getArrayStatement()));
//        System.out.println(Arrays.toString(ass.getOperationsByCustomer(1).orElseThrow()));
        ass.m1();
    }
}

