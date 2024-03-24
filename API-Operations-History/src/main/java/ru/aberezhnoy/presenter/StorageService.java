package ru.aberezhnoy.presenter;

import ru.aberezhnoy.model.ConsolePrintable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StorageService<T extends ConsolePrintable> implements Iterable<T> {
    private final List<T> data;
    private int idx;

    public StorageService() {
        this.data = new ArrayList<>();
        this.idx = 0;
    }

    public List<T> getData() {
        return data;
    }

    public void add(T element) {
        data.add(element);
    }

    public T getElementByIndex(int index) {
        return data.get(index);
    }

    public void removeByIndex(int index) {
        data.remove(index);
    }

    public boolean removeByElement(T element) {
        return data.remove(element);
    }

    private int indexOf(T element) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(element))
                return i;
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public void consolePrint() {
        for (T datum : data) {
            datum.print();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (T e : data) {
            if (e != null)
                sb.append(e).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return idx < data.size();
            }

            @Override
            public T next() {
                return data.get(idx++);
            }
        };
    }
}
