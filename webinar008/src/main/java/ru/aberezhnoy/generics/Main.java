package ru.aberezhnoy.generics;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
//        Burrow<Rabbit> rabbitBurrow = new Burrow<>();
        Burrow<Raccoon> raccoonBurrow = new Burrow<>();
//        Burrow<Car> carBurrow = new Burrow<>();

        Rabbit rabbit2 = new Rabbit();
        Raccoon raccoon = new Raccoon();

//        rabbitBurrow.setHabitat(rabbit2);
        raccoonBurrow.setHabitat(raccoon);

//        Rabbit rabbit1 = rabbitBurrow.getHabitat();
        Raccoon raccoon1 = raccoonBurrow.getHabitat();

        Util.setIfBurrowEmpty(raccoonBurrow, raccoon);
        System.out.println(raccoonBurrow.getHabitat());

    }
}

class Burrow<T extends Animal & Serializable> {
    T habitat;

    public void setHabitat(T habitat) {
        this.habitat = habitat;
    }

    public T getHabitat() {
        return habitat;
    }
}

class Rabbit extends Animal {
}

class Raccoon extends Animal implements Serializable {
}

class Car {
}

abstract class Animal {
}

class Util {
    public static <T extends Animal & Serializable> void setIfBurrowEmpty(Burrow<T> burrow, T t) {
        if (burrow.getHabitat() == null) {
            burrow.setHabitat(t);
        }
    }
}

