package ru.aberezhnoy.factory;

import ru.aberezhnoy.model.CustomerRepository;
import ru.aberezhnoy.model.OperationRepository;
import ru.aberezhnoy.presenter.CustomerService;
import ru.aberezhnoy.presenter.OperationService;
import ru.aberezhnoy.presenter.Presenter;

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

    public static OperationService getOperationService() {
        return OperationService.getInstance();
    }

    public static CustomerService getCustomerService() {
        return CustomerService.getInstance();
    }

    public static Presenter getPresenter() {
        return Presenter.getInstance();
    }
}
