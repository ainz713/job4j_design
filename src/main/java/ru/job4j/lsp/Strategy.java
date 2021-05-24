package ru.job4j.lsp;

public interface Strategy {

    boolean add(Food food);

    boolean accept(Food food);
}
