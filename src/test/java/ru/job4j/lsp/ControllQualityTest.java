package ru.job4j.lsp;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest  {

    @Test
    public void controllShop() {
        LocalDate expiryDate = LocalDate.parse("2021-06-28");
        LocalDate createDate = LocalDate.parse("2021-05-10");
        Meat meat = new Meat("МЯсцо", expiryDate, createDate, 150, 0);
        ControllQuality cq = new ControllQuality();
        cq.whatStorage(cq.executeDate(meat), meat);
        assertThat(Shop.getShop().get(0), is(meat));
    }

    @Test
    public void controllTrash() {
        LocalDate expiryDate = LocalDate.parse("2021-03-21");
        LocalDate createDate = LocalDate.parse("2021-03-16");
        Milk milk = new Milk("молочко домик в деревне", expiryDate, createDate, 50, 0);
        ControllQuality cq = new ControllQuality();
        cq.whatStorage(cq.executeDate(milk), milk);
        assertThat(Trash.getTrash().get(0), is(milk));
    }

    @Test
    public void controllWarehouse() {
        LocalDate expiryDate = LocalDate.parse("2021-07-30");
        LocalDate createDate = LocalDate.parse("2021-05-22");
        Fish fish = new Fish("палтус", expiryDate, createDate, 100, 0);
        ControllQuality cq = new ControllQuality();
        cq.whatStorage(cq.executeDate(fish), fish);
        assertThat(Warehouse.getWarehouse().get(0), is(fish));
    }
}