package ru.aberezhnoy.presenter;

import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.util.Statement;

import java.util.Set;

public class Presenter {
    private Statement statement;

    public Set<Operation> getOperationByCustomer(long id) {
        return statement
                .getOperationByCustomer(id)
                .orElseThrow(() -> new CustomerNotFound(id));
    }

}
