package ru.aberezhnoy.persist.model;

import ru.aberezhnoy.persist.ConsolePrintable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Customer implements ConsolePrintable, Comparable<Customer> {
    private long id;
    private String firstname;
    private String lastname;
    private String surname;
    private LocalDate birthDate;
    private Gender gender;
    private String email;
    private String phoneNumber;

    public Customer() {
    }

    private Customer(Long id, String firstname, String lastname, String surname, String birthDate, String gender, String email, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String fullname = firstname.toUpperCase().charAt(0) +
                "." + lastname.toUpperCase().charAt(0) +
                "." + surname;
        return String.format("Customer id; %d, full name: %s, day of birth: %s", id, fullname, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return id == customer.id && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(firstname, customer.firstname) && Objects.equals(lastname, customer.lastname) && Objects.equals(surname, customer.surname) && gender == customer.gender && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, surname, gender, email, phoneNumber);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int compareTo(Customer o) {
        if (birthDate.isAfter(o.birthDate)) return 1;
        else if (this.birthDate.isBefore(o.birthDate)) return -1;
        else return 0;
    }

    @Override
    public void print() {
        System.out.printf("Id: %d, surname: %s%n", id, surname);
    }

    private enum Gender {
        MALE, FEMALE
    }

    public static class Builder {
        private final Customer customer;

        public Builder() {
            this.customer = new Customer();
        }

        public Builder setFirstname(String firstname) {
            this.customer.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.customer.lastname = lastname;
            return this;
        }

        public Builder setSurname(String surname) {
            this.customer.surname = surname;
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.customer.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return this;
        }

        public Builder setGender(String gender) {
            this.customer.gender = Gender.valueOf(gender.toUpperCase());
            return this;
        }

        public Builder setEmail(String email) {
            this.customer.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.customer.phoneNumber = phoneNumber;
            return this;
        }

        public Customer build() {
            return this.customer;
        }
    }
}
