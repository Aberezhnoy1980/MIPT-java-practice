package ru.aberezhnoy.lesson.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Dequeue {
    public static void main(String[] args) {
        Deque<String> dq = new LinkedList<>();
        dq.offerFirst("Petya");
        System.out.println(dq.pollLast());

        Deque<String> ad = new ArrayDeque<>();
        ad.push("Luchezar");
        ad.push("Klovert");
        ad.push("Zluka");

        while (!ad.isEmpty()) {
            System.out.println(ad.pop());
        }

        Stack<String> s = new Stack<>();
        s.push("Petya");
        s.push("Olya");
        s.push("Tanya");

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
