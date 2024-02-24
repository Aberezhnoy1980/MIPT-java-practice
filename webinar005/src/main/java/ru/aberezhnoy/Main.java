package ru.aberezhnoy;

import ru.aberezhnoy.pack1.Document;
import ru.aberezhnoy.pack1.Num;
import ru.aberezhnoy.pack1.Passport;

public class Main {
    public static void main(String[] args) {
//        int i = 5;
//        int[] arr = new int[9];
//
//        Passport passport = new Passport("Ivan", "Ivanov",  "Ivanovich", 123);
//
//        passport.setLastName("Petrov");
//
//        System.out.println(passport);
//
//        Num n1 = new Num();
//        Num.num = 45;
//        Num n2 = new Num();
//        Num n3 = new Num();
//
//        System.out.println(n1);
//        System.out.println(n2);
//        System.out.println(n3);
//
//        System.out.println("+");
//
//        Num.print(3);
//        Num.print(3.5);
//
//        change(passport, "Ignat");
//        System.out.println(passport);
//        change2(passport);
//        System.out.println(passport);

        Document passport = new Passport();
        passport.setFirstName("Vasiliy");
        passport.setLastName("Vasilievich");
        passport.setMiddleName("Vasillyev");
        passport.setNumber(987);

        System.out.println(passport);

        System.out.println("+");

        passport.validate();
        passport.getInfo();
    }

    public static void change(Passport passport, String newName) {
        passport.setFirstName(newName);
    }

    public static void change2(Passport passport) {
        passport = null;
    }
}
