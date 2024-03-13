package ru.aberezhnoy.persist;

import ru.aberezhnoy.exception.OperationNotFound;
import ru.aberezhnoy.persist.model.Operation;
import ru.aberezhnoy.util.Storage;

import java.util.concurrent.atomic.AtomicLong;

public class OperationRepository implements TransactionRepository<Operation> {
    private static AtomicLong identity;
    private final Storage<Operation> operations;
    static OperationRepository instance;

    private OperationRepository() {
        identity = new AtomicLong(0);
        this.operations = new Storage<>();

    }

    public static OperationRepository getInstance() {
        if (instance == null) {
            return new OperationRepository();
        }
        return instance;
    }

    @Override
    public void findAll() {
        operations.consolePrint();
    }

    @Override
    public Operation findById(long id) {
        for (int i = 0; i < operations.size(); i++) {
            if (operations.getElementByIndex(i).getId() == id) {
                return operations.getElementByIndex(i);
            }
        }
        throw new OperationNotFound(String.format("Operation with id %s not found%n", id));
    }

    @Override
    public OperationRepository save(Operation operation) {
        operation.setId(identity.incrementAndGet());
        operations.add(operation);
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
        if (operations.contains(findById(id))) {
            operations.removeByElement(findById(id));
        } else
            throw new OperationNotFound(String.format("Operation with id %s not found%n", id));
    }

}
