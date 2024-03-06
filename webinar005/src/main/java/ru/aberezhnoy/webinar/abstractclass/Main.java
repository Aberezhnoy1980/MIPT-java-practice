package ru.aberezhnoy.webinar.abstractclass;

public class Main {
    public static void main(String[] args) {
        String name = "Petya";
        final Car car = new Car();
//        car.transfer(name, "SPB", "MSK");
        spbToMoscow(name, car);

        final Ship ship = new Ship();
//        ship.transfer(name, "SPB", "MSK");
        spbToMoscow(name, ship);

//        final Transport transport = new Transport(10);
//        spbToMoscow(name, transport);

        final Plane plane = new Plane();
        spbToMoscow(name, plane);

        final Bicycle bicycle = new Bicycle();
        spbToMoscow(name, bicycle);

    }

    public static void spbToMoscow(String name, Carrier transport) {
        transport.transfer(name, "SPB", "MSK");
    }
}
