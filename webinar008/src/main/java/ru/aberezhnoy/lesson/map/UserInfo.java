package ru.aberezhnoy.lesson.map;

import java.util.Objects;

public class UserInfo {
    private final String name;
    private String surName;
    private final int age;

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof UserInfo userInfo)) return false;
        return userInfo.name.equals(this.name) && this.surName.equals(((UserInfo) o).surName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surName);
    }
}
