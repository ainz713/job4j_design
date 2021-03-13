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
        while (point < data.length) {
            if (data[point] % 2 == 0) {
                return true;
            }
            point++;
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
