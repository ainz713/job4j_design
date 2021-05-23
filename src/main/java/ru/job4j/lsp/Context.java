package ru.job4j.lsp;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(Food food) {
        return strategy.add(food);
    }
}
