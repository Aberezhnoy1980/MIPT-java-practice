package ru.aberezhnoy.lesson.map;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {
    protected List<MyMapPair<K, V>> pairs;

    public MyMap() {
        this.pairs = new ArrayList<>();
    }

    public void put(K key, V value) {
        for (MyMapPair<K, V> p : pairs) {
            if (p.getKey().equals(key)) {
                p.setValue(value);
                return;
            }
        }
        pairs.add(new MyMapPair<>(key, value));
    }

    public V get(K key) {
        for (MyMapPair<K, V> p : pairs) {
            if (p.getKey().equals(key)) return p.getValue();
        }
        throw new RuntimeException("Element not found");
    }

    public List<MyMapPair<K, V>> getPairs() {
        return pairs;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (MyMapPair<K, V> r : pairs) {
            sb.append("[ ").append(r.getKey()).append(" : ").append(r.getValue()).append(" ]").append("\n");
        }
        System.out.println(sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MyMapPair<K, V> r : pairs) {
            sb.append("[ ").append(r.getKey()).append(" : ").append(r.getValue()).append(" ]").append("\n");
        }
        return sb.toString();
    }
}
