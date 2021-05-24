package ru.job4j.lsp;

import java.util.List;

public class ControllQuality {

    public ControllQuality() {
    }

    public void whatStorage(List<Strategy> strategy, Food food) {
        for (Strategy e
                :strategy) {
            if (e.accept(food)) {
                new Context(e).executeStrategy(food);
            }
        }
    }
}
