package ru.aberezhnoy.presenter;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.CustomerRepository;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.Operation;

import java.util.Set;

public class Presenter implements Contract.Presenter {
    private final CustomerService customerService;
    private final OperationService operationService;
    private final StatementService statementService;
    static Presenter instance;

    public Presenter() {
        this.customerService = Factory.getCustomerService();
        this.operationService = Factory.getOperationService();
        this.statementService = new StatementService(customerService.findAll(), operationService.findAll());
        statementService.getMapStatement();
    }

    public static Presenter getInstance() {
        if (instance == null) {
            return new Presenter();
        }
        return instance;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerService.save(customer);
        statementService.addCustomer(customer);
    }

    @Override
    public void saveOperation(Operation operation) {
        operationService.save(operation);
        Customer customer = customerService.findById(operation.getCustomerId());
        customer.addOperations(operation);
        statementService.updateCustomer(customer);
    }

    @Override
    public void showAllCustomers() {
        for (Customer c : statementService.getAllCustomers()) {
            System.out.println(c);
        }
    }

    @Override
    public void showAllOperations() {
        for (Operation o : statementService.getAllOperations()) {
            System.out.println(o);
        }
    }

    @Override
    public void showOperationsByCustomer(long id) {
        Set<Operation> customerOperations = statementService.getOperationsByCustomer(id).orElseThrow(() -> new CustomerNotFound(id));
        for (Operation o : customerOperations) {
            System.out.println(o);
        }
    }
}
