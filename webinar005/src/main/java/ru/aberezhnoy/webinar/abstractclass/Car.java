package ru.aberezhnoy.webinar.abstractclass;

public class Car extends Transport {
    public Car() {
        super(100);
    }

    @Override
    public void transfer(String name, String from, String to) {
        System.out.printf("%s drove car from %s to %s%n", name, from, to);
        spendFuel(10);
    }
}
