package ru.aberezhnoy.webinar.abstractclass;

public class Bicycle implements Carrier {
    @Override
    public void transfer(String name, String from, String to) {
        System.out.printf("%s rode his %s from %s to %s", name, this.getClass().getSimpleName(), from, to);
    }
}
