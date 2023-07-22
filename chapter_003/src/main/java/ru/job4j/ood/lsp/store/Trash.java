package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

public class Trash extends AbstractStore {

    @Override
    public void add(Food food, Double percentOfShelfLife) {
        if (percentOfShelfLife > 100) {
            findAll().add(food);
        }
    }
}
