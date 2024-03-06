package ru.aberezhnoy.webinar;

public class Singer extends Person {
    private int rating;

    public Singer(String name, int age, int rating) {
        super(name, age);
        this.rating = rating;
    }

    public Singer() {
        super();
    }

    public Singer(String name) {
        super(name);
    }

    @Override
    public void happyBirthday() {
        age++;
        System.out.println("I'm sing with HB to myself");
    }

    public void sing(String verse) {
        System.out.println("I'm sing: " + verse);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%d)", rating, getName(), getAge());
    }
}
