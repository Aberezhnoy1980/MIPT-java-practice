package ru.aberezhnoy.model;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.OperationNotFound;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.util.Storage;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class OperationRepository implements Contract.Model<Operation> {
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

    /**
     * For future scaling and connection with real databases
     * @return An Optional with te value present
     */
    @Override
    public Optional<Storage<Operation>> findAll() {
        return Optional.of(operations);
    }

    @Override
    public Optional<Operation> findById(long id) {
        for (int i = 0; i < operations.size(); i++) {
            if (operations.getElementByIndex(i).getId() == id) {
                return Optional.of(operations.getElementByIndex(i));
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(Operation operation) {
        operation.setId(identity.incrementAndGet());
        operations.add(operation);
    }

    @Override
    public void removeById(long id) {
        operations.removeByElement(findById(id).orElseThrow(() -> new OperationNotFound(id)));
    }
}
