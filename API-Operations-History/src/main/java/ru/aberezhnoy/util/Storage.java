package ru.aberezhnoy.util;

import ru.aberezhnoy.model.ConsolePrintable;

import java.util.Iterator;

public class Storage<T extends ConsolePrintable> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 8;
    private T[] data;
    private int size;
    private int idx;

    @SuppressWarnings("unchecked")
    public Storage(int initialCapacity) {
        this.data = (T[]) new ConsolePrintable[initialCapacity];
        this.size = 0;
        this.idx = 0;
    }

    public Storage() {
        this(DEFAULT_CAPACITY);
    }

    public T[] getData() {
        return data;
    }

    @SuppressWarnings("unchecked")
    public Storage<T> add(T element) {
        if (data.length == size) {
            T[] temp = (T[]) new ConsolePrintable[size * 2];
            System.arraycopy(data, 0, temp, 0, size);
            data = temp;
        }
        data[size++] = element;
        return this;
    }

    public T getElementByIndex(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(String.format("Incorrect 'index': %d; max index: %d", index, size - 1));
    }

    public T removeByIndex(int index) {
        checkIndex(index);
        T removedElement = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return removedElement;
    }

    public boolean removeByElement(T element) {
        int index = indexOf(element);
        return index != -1 && removeByIndex(index) != null;
    }

    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                return i;
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void consolePrint() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                data[i].print();
            }
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
                return idx < size;
            }

            @Override
            public T next() {
                return data[idx++];
            }
        };
    }
}
