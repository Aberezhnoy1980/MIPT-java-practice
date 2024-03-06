package ru.aberezhnoy.webinar.abstractclass;

public class Plane extends Transport {
    public Plane() {
        super(10_000);
    }

    @Override
    public void transfer(String name, String from, String to) {
        System.out.printf("%s flew by %s from %s to %s%n", name, this.getClass().getSimpleName(), from, to);
        spendFuel(3_000);
    }
}
