package ru.aberezhnoy.presenter;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.exception.SetIsNotExistsException;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.util.Storage;

public class CustomerService {
    private final Contract.Model<Customer> customerRepository;
    static CustomerService instance;

    public CustomerService() {
        this.customerRepository = Factory.getCustomerRepository();
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            return new CustomerService();
        }
        return instance;
    }

    public Storage<Customer> findAll() {
        return customerRepository.findAll().orElseThrow(SetIsNotExistsException::new);
    }

    public Customer findById(long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFound(id));
    }

    public CustomerService save(Customer customer) {
        customerRepository.save(customer);
        return this;
    }

    public void removeById(long id) {
        customerRepository.removeById(id);
    }
}
