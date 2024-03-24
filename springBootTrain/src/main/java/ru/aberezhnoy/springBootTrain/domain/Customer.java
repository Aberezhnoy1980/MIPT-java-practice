package ru.aberezhnoy.springBootTrain.domain;

public class Customer {
    private int id;
    private String name;

    public Customer() {
    }

    public Customer(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
