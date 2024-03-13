package ru.aberezhnoy.persist;

import ru.aberezhnoy.persist.model.Operation;

public interface TransactionRepository<T> {
    void findAll();

    T findById(long id);

    TransactionRepository<T> save(T element);

    void removeById(long id);
}
