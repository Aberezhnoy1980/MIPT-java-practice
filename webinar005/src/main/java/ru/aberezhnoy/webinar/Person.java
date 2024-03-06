package ru.aberezhnoy.webinar;

public class Person {
    protected String name;
    protected int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this(name, 10);
    }

    protected boolean isTooYang() {
        return age < 18;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if (age < 0 || age > 200) return;
        this.age = age;
    }

    protected void happyBirthday() {
        age++;
        System.out.println("With HB!");
    }
}
