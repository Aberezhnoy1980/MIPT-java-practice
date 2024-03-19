package ru.aberezhnoy.contract;

import ru.aberezhnoy.model.ConsolePrintable;
import ru.aberezhnoy.util.Storage;

public interface TransactionRepository<T extends ConsolePrintable> {
    Storage<T> findAll();

    T findById(long id);

    void save(T element);

    void removeById(long id);
}
