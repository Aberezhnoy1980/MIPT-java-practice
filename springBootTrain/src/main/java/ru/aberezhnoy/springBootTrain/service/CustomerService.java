package ru.aberezhnoy.springBootTrain.service;

import org.springframework.stereotype.Service;
import ru.aberezhnoy.springBootTrain.domain.Customer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final List<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
        customers.add(new Customer(1, "Client1"));
        customers.add(new Customer(2, "Client2"));
        customers.add(new Customer(3, "Client3"));
        customers.add(new Customer(4, "Client4"));
    }

    public void createCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

}
