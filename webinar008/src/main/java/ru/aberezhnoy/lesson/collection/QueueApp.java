package ru.aberezhnoy.lesson.collection;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueApp {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Petya");
        queue.offer("Olya");
        queue.offer("Tanya");

//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.isEmpty());

        while (!queue.isEmpty()) {
            String s = queue.poll();
            System.out.println(s);
        }

        System.out.println(queue);

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.charAt(1)));
        priorityQueue.offer("Petya");
        priorityQueue.offer("Olya");
        priorityQueue.offer("Tanya");

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
