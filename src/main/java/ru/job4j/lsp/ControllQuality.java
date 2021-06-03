package ru.job4j.lsp;

import java.util.ArrayList;
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

    public List<Food> getAllProducts(List<Storage> storages) {
        List<Food> foodst = new ArrayList<>();
        for (Storage e
                : storages) {
            foodst.addAll(e.get());
            e.remove();
        }
        return foodst;
    }

    public void resort(List<Storage> storages, List<Food> foodst) {
            for (Food g
                    :foodst) {
            whatStorage(storages, g);
            }
        }
}
