package ru.aberezhnoy.presenter;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.util.StatementService;

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

    @Override
    public void saveCustomer(Customer customer) {
        customerService.save(customer);
        statementService.addCustomer(customer);
    }

    @Override
    public void saveOperation(Operation operation) {
        operationService.save(operation);
        long id = operation.getCustomerId();
        Customer customer = customerService.findById(operation.getCustomerId());
        customer.addOperations(operation);
        statementService.updateCustomer(customer);
    }

    @Override
    public void findAllCustomers() {
        statementService.findAllCustomers();
    }

    @Override
    public void findAllOperations() {
        statementService.findAllOperations();
    }

    @Override
    public Set<Operation> findOperationsByCustomer(long id) {
        return statementService.getOperationsByCustomer(id).orElseThrow(() -> new CustomerNotFound(id));
    }

    public int[] findOperationsByCustomer2(long id) {
        return statementService.getOperationsByCustomer2(id).orElseThrow(() -> new CustomerNotFound(id));
    }
}
