package ru.aberezhnoy.util;

import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.Operation;

import java.util.*;

/**
 * Class for Implementation of one-to-many relationship
 */
public class Statement {
    /**
     * It's for example
     */
    private final int[][] arrayStatement;
    private final Map<Customer, Set<Operation>> statement;

    private final Storage<Customer> customers;
    private final Storage<Operation> operations;

    public Statement(Storage<Customer> customers, Storage<Operation> operations) {
        this.customers = customers;
        this.operations = operations;
        this.statement = new HashMap<>();
        this.arrayStatement = new int[customers.size()][];
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
        return statement;
    }

    /**
     * @param customer
     * @return
     */
    public Set<Operation> getOperationByCustomer(Customer customer) {
        return statement.get(customer);
    }

    public int[] getOperationByCustomer(Customer customer) {

        return statement.get(customer);
    }

    /**
     * Overloaded method for two-dimensional array
     *
     * @return two-dimensional array
     */
    public int[][] getArrayStatement() {
        return arrayStatement;
    }

//    public Statement add(int customerId, int operationId) {
//        statement[customerId - 1][] = operationId;
//        return this;
//    }
}
