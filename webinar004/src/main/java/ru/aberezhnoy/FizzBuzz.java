package ru.aberezhnoy;

public class FizzBuzz {
    /* Практика "FizzBuzz"
    Напишите программу, которая выводит на экран числа от 1 до 100.
    При этом вместо чисел, кратных трём, программа должна выводить слово «Fizz»,
    а вместо чисел, кратных пяти — слово «Buzz».
    Если число кратно и 3, и 5, то программа должна выводить слово «FizzBuzz»
    */

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }

}
