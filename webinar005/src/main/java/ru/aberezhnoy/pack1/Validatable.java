package ru.aberezhnoy.pack1;

import java.time.LocalDate;

public interface Validatable {
    int CONST = 34;

    void validate();

    default void getInfo() {
        System.out.println(this);
    }

    boolean isValid(LocalDate date);
}
