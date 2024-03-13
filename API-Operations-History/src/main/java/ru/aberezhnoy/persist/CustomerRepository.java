package ru.aberezhnoy.persist;

import ru.aberezhnoy.exception.OperationNotFound;
import ru.aberezhnoy.persist.model.Customer;
import ru.aberezhnoy.util.Storage;

import java.util.concurrent.atomic.AtomicLong;

public class CustomerRepository implements TransactionRepository<Customer> {
    private static AtomicLong identity;
    private final Storage<Customer> customers;
    static CustomerRepository instance;

    private CustomerRepository() {
        identity = new AtomicLong(0);
        this.customers = new Storage<>();

    }

    public static CustomerRepository getInstance() {
        if (instance == null) {
            return new CustomerRepository();
        }
        return instance;
    }

    @Override
    public void findAll() {
        customers.consolePrint();
    }

    @Override
    public Customer findById(long id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.getElementByIndex(i).getId() == id) {
                return customers.getElementByIndex(i);
            }
        }
        throw new OperationNotFound(String.format("Operation with id %s not found%n", id));
    }

    @Override
    public CustomerRepository save(Customer customer) {
        customer.setId(identity.incrementAndGet());
        customers.add(customer);
        return this;
    }

//    public void saveOperation(Scanner sc) {
//
//        operation.setId(identity.incrementAndGet());
//        operations.add(operation);
//        return this;
//    }

    @Override
    public void removeById(long id) {
        if (customers.contains(findById(id))) {
            customers.removeByElement(findById(id));
        } else
            throw new OperationNotFound(String.format("Operation with id %s not found%n", id));
    }

}
