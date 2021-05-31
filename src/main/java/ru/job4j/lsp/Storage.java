package ru.job4j.lsp;

import java.util.List;

public interface Storage {

    boolean add(Food food);

    List<Food> get();

    boolean remove();

    boolean accept(Food food);
}
