package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator {
    private final int[] data;
    private int point = 0;

    public EvenIt(final int[] numbers) {
        this.data = numbers;
    }

    @Override
    public boolean hasNext() {
        if (data[point] % 2 != 0 && data.length != 1 && data[point] < data.length) {
            point++;
        }
        return data[point] % 2 == 0;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
