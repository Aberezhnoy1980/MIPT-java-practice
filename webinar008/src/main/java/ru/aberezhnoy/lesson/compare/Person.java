package ru.aberezhnoy.lesson.compare;

public class Person implements Comparable<Person> {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
//        if (this.age > o.age) return 1;
//        else if (this.age < o.age) return -1;
//        else return 0;
//        return this.age - o.age;
//        return Integer.compare(this.age, o.age);
        return (this.age != o.age) ? Integer.compare(this.age, o.age) : this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("\nName: %s, age: %d", name, age);
    }
}
