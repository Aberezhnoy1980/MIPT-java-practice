package ru.aberezhnoy.pack1;

import java.time.LocalDate;

public class Passport extends Document {
    private int number;

    public Passport() {
        super();
    }

    public Passport(String firstName, String lastName, String middleName, int number) {
        super(firstName, lastName, middleName);
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("First name: %s, last name: %s, middle name: %s, number: %d", getFirstName(), getLastName(), getMiddleName(), number);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean isValid(LocalDate d) {
        return true;
    }
}
