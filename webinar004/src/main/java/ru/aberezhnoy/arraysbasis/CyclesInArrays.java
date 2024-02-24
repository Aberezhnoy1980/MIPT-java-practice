package ru.aberezhnoy.arraysbasis;

public class CyclesInArrays {
    public static void main(String[] args) {
        String[] names = {
                "Petya",
                "Olya",
                "Anya",
                "Pavel",
                "Oleg"
        };

        if (!names[0].startsWith("P")) {
            System.out.println(names[0]);
        }
    }
}
