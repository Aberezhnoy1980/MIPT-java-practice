package ru.aberezhnoy.strings;

public class Main {
    public static void main(String[] args) {
//        String s = "Hello World";
//        System.out.println(s.replace('l', '@'));
//        System.out.println(s);
//        s = s.replace('l', '@');
//        System.out.println(s);
//        s = s + "Hello";
//        s = s + " ";
//        s = s + "World";
//        System.out.println("\n" + s);
//
        final StringBuilder sb = new StringBuilder();
//        sb.append("Hello").append(" ").append("World");
//        System.out.println(s);

        System.out.println("Start!");
//        String str = "";
        final int STEPS = 1_000_000;
        for (int i = 0; i < STEPS; i++) {
            if (i % (STEPS / 100) == 0) System.out.println((i / (STEPS / 100)) + "%...");
//            str = str + '!';
            sb.append('!');
        }
        String str = sb.toString();
        System.out.println("Finish!");

        System.out.println("Generated string with " + str.length() + " length");
    }
}
