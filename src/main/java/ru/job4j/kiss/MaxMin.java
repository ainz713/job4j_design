package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T t = value.get(0);
        for (T item : value) {
            if (comparator.compare(item, t) > 0) {
                t = item;
            }
        }
        return t;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }
}
