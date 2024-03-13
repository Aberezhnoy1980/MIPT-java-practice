package ru.aberezhnoy.view;

import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.persist.TransactionRepository;
import ru.aberezhnoy.persist.model.Customer;
import ru.aberezhnoy.persist.model.Operation;

public class View {
    private final TransactionRepository<Operation> or;
    private final TransactionRepository<Customer> cr;

    public View() {
        this.or = Factory.getOperationRepository();
        this.cr = Factory.getCustomerRepository();
    }
}
