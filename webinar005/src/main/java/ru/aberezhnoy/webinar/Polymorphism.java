package ru.aberezhnoy.webinar;

public class Polymorphism {
    public static void main(String[] args) {
        Person person = new Singer("Tanya", 15, 4); // new Person("Petya", 8);

        person.happyBirthday();

        Singer singer = new Singer("Sveta", 13, 5);

        if (checkPerson(singer)) {

        }
    }

    public static boolean checkPerson(Person person) {
        return person.getAge() < 18;
    }
}
