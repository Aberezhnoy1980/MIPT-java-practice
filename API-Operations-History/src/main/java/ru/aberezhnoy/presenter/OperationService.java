package ru.aberezhnoy.presenter;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.OperationNotFound;
import ru.aberezhnoy.exception.SetIsNotExistsException;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.util.Storage;

public class OperationService {
    private final Contract.Model<Operation> operationRepository;
    static OperationService instance;

    public OperationService() {
        this.operationRepository = Factory.getOperationRepository();
    }

    public static OperationService getInstance() {
        if (instance == null) {
            return new OperationService();
        }
        return instance;
    }

    public Storage<Operation> findAll() {
        return operationRepository.findAll().orElseThrow(SetIsNotExistsException::new);
    }

    public Operation findById(long id) {
        return operationRepository.findById(id).orElseThrow(() -> new OperationNotFound(id));
    }

    public OperationService save(Operation operation) {
        operationRepository.save(operation);
        return this;
    }

    public void removeById(long id) {
        operationRepository.removeById(id);
    }
}
