package ru.aberezhnoy.exception;

public class OperationNotFound extends RuntimeException {
    public OperationNotFound(String msg) {
        super(msg);
    }
}
