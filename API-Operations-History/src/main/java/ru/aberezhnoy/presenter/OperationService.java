package ru.aberezhnoy.presenter;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.exception.OperationNotFound;
import ru.aberezhnoy.exception.SetIsNotExistsException;
import ru.aberezhnoy.exception.UnexpectedChoiceException;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.contract.TransactionRepository;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.util.Storage;

import java.util.Optional;

public class OperationService {
    private Contract.Model<Operation> or;
    private Contract.Model<Customer> cr;
    static OperationService instance;

    public OperationService() {
        this.or = Factory.getOperationRepository();
        this.cr = Factory.getCustomerRepository();
    }

    public static OperationService getInstance() {
        if (instance == null) {
            return new OperationService();
        }
        return instance;
    }

    public Storage<Operation> findAll() {
        return or.findAll().orElseThrow(SetIsNotExistsException::new);
    }

    public Operation findById(long id) {
        return or.findById(id).orElseThrow(() -> new OperationNotFound(id));
    }

    public OperationService save(Operation operation) {
        or.save(operation);
//        long id = operation.getCustomerId();
//        Customer customer = cr.findById(operation.getCustomerId()).orElseThrow(() -> new CustomerNotFound(id));
//        customer.addOperations(operation);
        return this;
    }

    public void removeById(long id) {
        or.removeById(id);
    }
}
