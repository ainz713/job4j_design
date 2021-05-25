package ru.job4j.lsp;

import java.util.List;

public class ControllQuality {

    private Strategy strategy;

    public ControllQuality() {
    }

    public ControllQuality(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(Food food) {
        return strategy.add(food);
    }

    public void whatStorage(List<Strategy> strategy, Food food) {
        for (Strategy e
                :strategy) {
            if (e.accept(food)) {
                new ControllQuality(e).executeStrategy(food);
            }
        }
    }
}
