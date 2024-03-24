package ru.aberezhnoy.presenter;

import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.util.Storage;

import java.util.Arrays;
import java.util.Optional;

/**
 * Training class for working with arrays
 */
public class ArrayStatementService {
    /**
     * Array declaration
     */
    private final int[][] statement;
    private final CustomerService customerService;
    private final OperationService operationService;
    private final Storage<Customer> customers;
    private final Storage<Operation> operations;


    public ArrayStatementService() {
        this.customerService = Factory.getCustomerService();
        this.operationService = Factory.getOperationService();
        this.customers = customerService.findAll();
        this.operations = operationService.findAll();
        this.statement = new int[customers.size()][];
    }

    public void m1() {
//        System.out.println(Arrays.toString(customers.getData()));
        System.out.println(customerService.findAll());
//        System.out.println(operations);
    }

    /**
     * Method which use only arrays
     */
//    private void buildTransactionsArray() {
//        int[] operationsArray;
//        int count = 0;
//        for (int i = 0; i < customers.size(); i++) {
//            for (Operation o : operations) {
//                if (o.getCustomerId() == customers.getElementByIndex(i).getId()) {
//                    count++;
//                }
//            }
//            operationsArray = new int[count];
//            count = 0;
//            for (Operation o : operations) {
//                if (o.getCustomerId() == customers.getElementByIndex(i).getId()) {
//                    operationsArray[count++] = Integer.parseInt(o.getId().toString());
//                }
//            }
//            for (int j = 0; j < operationsArray.length; j++) {
//                statement[i] = new int[operationsArray.length];
//                statement[i][j] = operationsArray[j];
//            }
//        }
//    }

    private void buildTransactionsArray() {

    }

    public Optional<int[]> getOperationsByCustomer(long id) {
        int[][] arrayStatement = getArrayStatement();
        int[] res;

        for (int i = 0; i < arrayStatement.length; i++) {
            if (id == customers.getElementByIndex(i).getId()) {
                res = new int[arrayStatement[i].length];
                System.arraycopy(arrayStatement[i], 0, res, 0, arrayStatement[i].length);
                return Optional.of(res);
            }
        }
        return Optional.empty();
    }

    public int[][] getArrayStatement() {
        buildTransactionsArray();
        return statement;
    }
}
