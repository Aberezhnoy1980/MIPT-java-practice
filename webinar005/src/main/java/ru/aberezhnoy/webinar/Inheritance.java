package ru.aberezhnoy.webinar;

public class Inheritance {
    public static void main(String[] args) {
        final Singer singer = new Singer();
        final Person person = new Person();
        singer.happyBirthday();
        person.happyBirthday();
        singer.setAge(15);
        singer.sing("hahahhlalallaa");
    }
}
