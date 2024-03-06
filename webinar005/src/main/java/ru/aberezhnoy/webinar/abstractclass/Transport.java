package ru.aberezhnoy.webinar.abstractclass;

public abstract class Transport implements Carrier, Payable {
    private int fuel;

    public Transport(int fuel) {
        this.fuel = fuel;
    }

    public void spendFuel(int fuel) {
        this.fuel -= fuel;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Payed " + amount);
    }
}
