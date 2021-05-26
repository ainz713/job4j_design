package ru.job4j.lsp;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest  {
    private List<Storage> st;
    private ControllQuality cq;

    @Before
    public void init() {
        st = new ArrayList<>();
        st.add(new Warehouse());
        st.add(new Shop());
        st.add(new Trash());
        cq = new ControllQuality();
    }

    @Test
    public void controllShop() {
        LocalDate expiryDate = LocalDate.parse("2021-06-28");
        LocalDate createDate = LocalDate.parse("2021-05-10");
        Meat meat = new Meat("МЯсцо", expiryDate, createDate, 150, 0);
        cq.whatStorage(st, meat);
        assertThat(Shop.getShop().get(0), is(meat));
    }

    @Test
    public void controllTrash() {
        LocalDate expiryDate = LocalDate.parse("2021-03-21");
        LocalDate createDate = LocalDate.parse("2021-03-16");
        Milk milk = new Milk("молочко домик в деревне", expiryDate, createDate, 50, 0);
        cq.whatStorage(st, milk);
        assertThat(Trash.getTrash().get(0), is(milk));
    }

    @Test
    public void controllWarehouse() {
        LocalDate expiryDate = LocalDate.parse("2021-07-30");
        LocalDate createDate = LocalDate.parse("2021-05-22");
        Fish fish = new Fish("палтус", expiryDate, createDate, 100, 0);
        cq.whatStorage(st, fish);
        assertThat(Warehouse.getWarehouse().get(0), is(fish));
    }
}