package ru.job4j.lsp;

import java.time.LocalDate;

public class Fish extends Food {
    public Fish(String name, LocalDate expiryDate, LocalDate createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
