package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {
    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
       objects[index++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, objects.length);
        objects[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, objects.length);
        System.arraycopy(objects, 0, objects, 0, index);
        System.arraycopy(objects, index + 1, objects, index, objects.length - index - 1);
    }

    public Object get(int index) {
        Objects.checkIndex(index, objects.length);
        return objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[point++];
            }
        };
    }
}
