package ru.job4j.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControllQuality {

    public ControllQuality() {
    }

    public int executeDate(Food food) {
        long wholeExp = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long currentExp = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return (int) (currentExp * 100L / wholeExp);
    }

    public void whatStorage(int num, Food food) {
        if (num >= 25 && num < 100) {
            food.setDiscount(0.2);
            new Context(new Shop()).executeStrategy(food);
        } else if (num >= 100) {
            new Context(new Trash()).executeStrategy(food);
        } else if (num < 25) {
            new Context(new Warehouse()).executeStrategy(food);
        }
    }
}
