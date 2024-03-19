package ru.aberezhnoy.exception;

public class SetIsNotExistsException extends RuntimeException {
    public SetIsNotExistsException() {
        super("Set is null");
    }
}
