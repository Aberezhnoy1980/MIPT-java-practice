package ru.aberezhnoy.factory;

import ru.aberezhnoy.persist.CustomerRepository;
import ru.aberezhnoy.persist.OperationRepository;

import java.util.Scanner;

public class Factory {
    public static OperationRepository getOperationRepository() {
        return OperationRepository.getInstance();
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static CustomerRepository getCustomerRepository() {
        return CustomerRepository.getInstance();
    }
}
