package ru.aberezhnoy.presenter;

import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.util.Storage;

import java.util.*;

/**
 * Class for Implementation of one-to-many relationship
 */
public class StatementService {
    private final Map<Customer, Set<Operation>> statement;
    private final Storage<Customer> customers;
    private final Storage<Operation> operations;

    public StatementService(Storage<Customer> customers, Storage<Operation> operations) {
        this.customers = customers;
        this.operations = operations;
        this.statement = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        statement.put(customer, customer.getOperations());
    }

    public void updateCustomer(Customer customer) {
        addCustomer(customer);
    }

    public Set<Customer> getAllCustomers() {
        return statement.keySet();
    }

    public Set<Operation> getAllOperations() {
        Set<Operation> res = new HashSet<>();
        for (Set<Operation> s : statement.values()) {
            res.addAll(s);
        }
        return res;
    }

    public Optional<Set<Operation>> getOperationsByCustomer(long id) {
        for (Customer c : customers) {
            if (c.getId() == id)
                return Optional.of(statement.get(c));
        }
        return Optional.empty();
    }

    private void buildTransactionsMap() {
        Set<Operation> operationSet = new HashSet<>();
        for (int i = 0; i < customers.size(); i++) {
            for (Operation o : operations) {
                if (o.getCustomerId() == customers.getElementByIndex(i).getId())
                    operationSet.add(o);
            }
//            statement.put(customers.getElementByIndex(i), customers.getElementByIndex(i).getOperations());
            statement.put(customers.getElementByIndex(i), operationSet);
            operationSet.clear();
        }
    }

    public Map<Customer, Set<Operation>> getMapStatement() {
        buildTransactionsMap();
        return statement;
    }

}
