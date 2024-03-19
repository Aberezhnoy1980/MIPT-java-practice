package ru.aberezhnoy.presenter;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.exception.OperationNotFound;
import ru.aberezhnoy.exception.SetIsNotExistsException;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.contract.TransactionRepository;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.util.CustomerValidator;
import ru.aberezhnoy.util.Storage;

import java.util.Optional;

public class CustomerService {
    private final Contract.Model<Customer> cs;
    static CustomerService instance;

    public CustomerService() {
        this.cs = Factory.getCustomerRepository();
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            return new CustomerService();
        }
        return instance;
    }

    public Storage<Customer> findAll() {
        return cs.findAll().orElseThrow(SetIsNotExistsException::new);
    }

    public Customer findById(long id) {
        return cs.findById(id).orElseThrow(() -> new CustomerNotFound(id));
    }

    public CustomerService save(Customer customer) {
        cs.save(customer);
        return this;
    }

    public void removeById(long id) {
        cs.removeById(id);
    }
}
