package ru.aberezhnoy.util;

import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.Operation;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class for Implementation of one-to-many relationship
 */
public class StatementService {
    /**
     * It's for example
     */
    private final int[][] arrayStatement;
    private final Map<Customer, Set<Operation>> statement;
    private final Storage<Customer> customers;
    private final Storage<Operation> operations;

    public StatementService(Storage<Customer> customers, Storage<Operation> operations) {
        this.customers = customers;
        this.operations = operations;
        this.statement = new HashMap<>();
        this.arrayStatement = new int[customers.size()][];
    }

    public void addCustomer(Customer customer) {
        statement.put(customer, customer.getOperations());
    }

    public void updateCustomer(Customer customer) {
        addCustomer(customer);
    }

    public void findAllCustomers() {
        System.out.println(statement.keySet());
    }

    public void findAllOperations() {
        Set<Operation> res = new HashSet<>();
        for (Set<Operation> s : statement.values()) {
            res.addAll(s);
        }
        System.out.println(res);
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

    /**
     * Method which use only arrays
     */
    private void buildTransactionsArray() {
        int[] operationsArray;
        int count = 0;
        for (int i = 0; i < customers.size(); i++) {
            for (Operation o : operations) {
                if (o.getCustomerId() == customers.getElementByIndex(i).getId()) {
                    count++;
                }
            }
            operationsArray = new int[count];
            count = 0;
            for (Operation o : operations) {
                if (o.getCustomerId() == customers.getElementByIndex(i).getId()) {
                    operationsArray[count++] = Integer.parseInt(o.getId().toString());
                }
            }
            for (int j = 0; j < operationsArray.length; j++) {
                arrayStatement[i][j] = operationsArray[j];
            }
        }
    }

    /**
     * Method
     *
     * @return hasMap with Customer as a key, and set of operations as a value.
     */
    public Map<Customer, Set<Operation>> getMapStatement() {
        buildTransactionsMap();
        return statement;
    }

    public Optional<Set<Operation>> getOperationsByCustomer(long id) {
        for (Customer c : customers) {
            if (c.getId() == id)
                return Optional.of(statement.get(c));
        }
        return Optional.empty();
    }

    public Optional<int[]> getOperationsByCustomer2(long id) {
        int[][] arrayStatement = getArrayStatement();
        int[] res;

        for (int i = 0; i < arrayStatement.length; i++) {
            if (id == customers.getElementByIndex(i).getId()) {
                res = new int[arrayStatement[i].length];
                for (int j = 0; j < arrayStatement[i].length; j++) {
                    res[j] = arrayStatement[i][j];
                }
                return Optional.of(res);
            }
        }
        return Optional.empty();
    }

//    public int[] getOperationByCustomer(Customer customer) {
//
//        return statement.get(customer);
//    }

    /**
     * Overloaded method for two-dimensional array
     *
     * @return two-dimensional array
     */
    public int[][] getArrayStatement() {
        buildTransactionsArray();
        return arrayStatement;
    }

//    public Statement add(int customerId, int operationId) {
//        statement[customerId - 1][] = operationId;
//        return this;
//    }
}
