package ru.aberezhnoy.lesson.generics;

public class MemoryApp {
    public static void main(String[] args) {
        Memory<String> memory = new Memory<>();
        memory.save("Petya");
        memory.save("Olya");
        memory.save("Tanya");
        System.out.println(memory.getLast());

        String v1 = "Petya";
        String v2 = "Olya";
        String result = choose(true, v1, v2);
    }

    public static <T> T choose(boolean flag, T first, T second) {
        return flag ? first : second;
    }
}
