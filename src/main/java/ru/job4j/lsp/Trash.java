package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Strategy {

    private static List<Food> trash;

    public Trash() {
        trash = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        return trash.add(food);
    }

    public static List<Food> getTrash() {
        return trash;
    }
}
