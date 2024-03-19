package ru.aberezhnoy.springBootTrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.springBootTrain.domain.Customer;
import ru.aberezhnoy.springBootTrain.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path ="api/customers")
public class CustomerController {
    private final CustomerService cs;

    @Autowired
    public CustomerController(CustomerService cs) {
        this.cs = cs;
    }

    @GetMapping()
    public List<Customer> getAll() {
        return cs.getCustomers();
    }

    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        return cs.getCustomerById(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        cs.createCustomer(customer);
    }
}
