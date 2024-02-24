package ru.aberezhnoy.arraysbasis;

public class Singer {

    public String name;
    public int age;
    public int rating;

    public Singer(String name, int age, int rating) {
        this.name = name;
        this.age = age;
        this.rating = rating;
    }

    public Singer(String name, int age) {
        this(name, age, 3);
    }
}
