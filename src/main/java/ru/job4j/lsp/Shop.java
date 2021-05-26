package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

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

    @Override
    public boolean accept(Food food) {
        int num = food.executeDate(food);
        if (num >= 25 && num < 100) {
            food.setDiscount(0.2);
            return true;
        }
        return false;
    }
}
