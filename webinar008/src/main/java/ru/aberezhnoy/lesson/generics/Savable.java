package ru.aberezhnoy.lesson.generics;

public interface Savable<T> {
    void save(T obj);
}
