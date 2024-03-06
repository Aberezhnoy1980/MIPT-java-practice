package ru.aberezhnoy.webinar.abstractclass;

public class Ship extends Transport {
    public Ship() {
        super(500);
    }

    @Override
    public void transfer(String name, String from, String to) {
        System.out.printf("%s sailed on a %s from %s to %s%n", name, this.getClass().getSimpleName(), from, to);
        spendFuel(80);
    }
}
