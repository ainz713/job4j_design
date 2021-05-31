package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private static List<Food> trash;

    public Trash() {
        trash = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        return trash.add(food);
    }

    @Override
    public List<Food> get() {
        return trash;
    }

    @Override
    public boolean remove() {
        return trash.removeAll(trash);
    }

    @Override
    public boolean accept(Food food) {
            int num = food.executeDate(food);
            if (num >= 100) {
                return true;
            }
            return false;
        }

    public static List<Food> getTrash() {
        return trash;
    }
}
