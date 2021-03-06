package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private static List<Food> warehouse;

    public Warehouse() {
        warehouse = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        return warehouse.add(food);
    }

    @Override
    public List<Food> get() {
        return warehouse;
    }

    @Override
    public boolean remove() {
        return warehouse.removeAll(warehouse);
    }

    @Override
    public boolean accept(Food food) {
            int num = food.executeDate(food);
            if (num < 25) {
                return true;
            }
            return false;
    }

    public static List<Food> getWarehouse() {
        return warehouse;
    }
}
