package ru.aberezhnoy.arraysbasis;

import java.util.Arrays;

public class CyclesInArrays {
    public static void main(String[] args) {
        String[] names = {
                "Petya",
                "Olya",
                "Anya",
                "Pavel",
                "Oleg"
        };
        for (int i = 0; i < names.length; i++) {
            if (!names[i].startsWith("P")) {
                System.out.println(names[i]);
            }
        }

        for (String name : names) {
            if (!name.startsWith("P")) System.out.println(name);
        }

        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

        String[] names2 = names.clone();
        names2[0] = null;

        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(names2));

    }
}
