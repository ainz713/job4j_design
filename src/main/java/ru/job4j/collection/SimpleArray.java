package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int size = 10;
    private int index = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.container = new Object[size];
    }

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T) container[index];
    }

    private void grow() {
        size *= 1.5;
        Object[] newElements = new Object[size];
        System.arraycopy(container, 0, newElements, 0, container.length);
        container = newElements;
    }

    public void add(T model) {
        modCount++;
        if (size == container.length) {
        grow();
        }
        container[index++] = model;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[point++];
            }
        };
    }
}