package ru.aberezhnoy.model;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.util.Storage;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerRepository implements Contract.Model<Customer> {
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
    public Optional<Storage<Customer>> findAll() {
        return Optional.of(customers);
    }

    @Override
    public Optional<Customer> findById(long id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.getElementByIndex(i).getId() == id) {
                return Optional.of(customers.getElementByIndex(i));
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(Customer customer) {
        customer.setId(identity.incrementAndGet());
        customers.add(customer);
    }

    @Override
    public void removeById(long id) {
        customers.removeByElement(findById(id).orElseThrow(() -> new CustomerNotFound(id)));
    }
}