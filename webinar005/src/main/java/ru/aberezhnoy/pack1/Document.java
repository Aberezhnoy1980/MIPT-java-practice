package ru.aberezhnoy.pack1;

import org.w3c.dom.css.CSSValueList;

import java.time.LocalDate;

public abstract class Document implements Validatable {

    private String firstName;
    private String lastName;
    private String middleName;

    public Document() {
    }

    public Document(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public abstract int getNumber();

    public abstract void setNumber(int number);


    @Override
    public void validate() {
        System.out.println("Done");
    }

    @Override
    public boolean isValid(LocalDate date) {
        return date.getYear() < LocalDate.now().getYear();
    }
}
