package ru.aberezhnoy;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.model.persist.CashbackOperation;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.LoanOperation;
import ru.aberezhnoy.presenter.Presenter;

import java.util.Arrays;

import static ru.aberezhnoy.util.Application.start;

public class MainApp {
    public static void main(String[] args) {
//        start();
        Presenter p = Presenter.getInstance();
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

        System.out.println(p.findOperationsByCustomer(1));
        System.out.println(Arrays.toString(p.findOperationsByCustomer2(1)));
    }
}
