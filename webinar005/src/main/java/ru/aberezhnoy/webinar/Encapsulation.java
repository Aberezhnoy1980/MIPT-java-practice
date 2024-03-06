package ru.aberezhnoy.webinar;

public class Encapsulation {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Petya");
        person.setAge(40);
        person.setAge(-8);

        System.out.println(person.isTooYang());
        System.out.println(person.getAge());
    }
}
