package ru.aberezhnoy.contract;

import ru.aberezhnoy.model.ConsolePrintable;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.util.Storage;

import java.util.Optional;
import java.util.Set;

public interface Contract {
    interface View {
        void run();
    }

    interface Model<T extends ConsolePrintable> {
        Optional<Storage<T>> findAll();

        Optional<T> findById(long id);

        void save(T element);

        void removeById(long id);
    }

    interface Presenter {
        void saveCustomer(Customer customer);

        void saveOperation(Operation operation);

        void findAllCustomers();
        void findAllOperations();

        Set<Operation> findOperationsByCustomer(long id);
    }
}
