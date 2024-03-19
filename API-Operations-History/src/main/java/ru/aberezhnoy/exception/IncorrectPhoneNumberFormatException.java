package ru.aberezhnoy.exception;

public class IncorrectPhoneNumberFormatException extends RuntimeException {
    public IncorrectPhoneNumberFormatException(String exp) {
        super("Error in phone number format: " + (exp.length() != 11 ? "incorrect digit counts" : "unacceptable symbols"));
    }
}
