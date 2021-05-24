package ru.job4j.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food {

   private String name;
   private LocalDate expiryDate;
   private LocalDate createDate;
   private int price;
   private double discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, int price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public int executeDate(Food food) {
        long wholeExp = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long currentExp = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return (int) (currentExp * 100L / wholeExp);
    }
}
