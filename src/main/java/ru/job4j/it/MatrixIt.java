package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (data[column].length == 0) {
            column++;
        }
       return column < data.length && data[column].length != 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (row == data[column].length) {
            row = 0;
            do {
                column++;
            } while (data[column].length == 0);
        }
        return data[column][row++];
    }
}
