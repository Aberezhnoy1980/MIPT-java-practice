package ru.aberezhnoy.exception;

public class IncorrectDateFormatException extends RuntimeException {
    public IncorrectDateFormatException(String msg) {
        super(msg);
    }
}
