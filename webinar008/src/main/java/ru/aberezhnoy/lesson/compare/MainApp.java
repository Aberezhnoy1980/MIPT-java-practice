package ru.aberezhnoy.lesson.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
                new Person("Petya", 24),
                new Person("Olya", 64),
                new Person("Anna", 23),
                new Person("Galina", 64),
                new Person("Anton", 24)
        ));

        Collections.sort(people);
        System.out.println(people);

        people.sort(new PersonsNameLengthComparator());
        System.out.println(people);
    }
}


