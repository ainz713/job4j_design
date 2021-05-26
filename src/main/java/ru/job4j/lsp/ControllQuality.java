package ru.job4j.lsp;

import java.util.List;

public class ControllQuality {

    private Storage storage;

    public ControllQuality() {
    }

    public ControllQuality(Storage storage) {
        this.storage = storage;
    }

    public void whatStorage(List<Storage> storages, Food food) {
        for (Storage e
                :storages) {
            if (e.accept(food)) {
                e.add(food);
                break;
            }
        }
    }
}
