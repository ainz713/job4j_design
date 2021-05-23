package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Strategy {
    private static List<Food> warehouse;

    public Warehouse() {
        warehouse = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        return warehouse.add(food);
    }

    public static List<Food> getWarehouse() {
        return warehouse;
    }
}
