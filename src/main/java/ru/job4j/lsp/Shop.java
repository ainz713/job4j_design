package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Strategy {

    private static List<Food> shop;

    public Shop() {
        shop = new ArrayList<>();
    }

    public static List<Food> getShop() {
        return shop;
    }

    @Override
    public boolean add(Food food) {
        return shop.add(food);
    }
}
