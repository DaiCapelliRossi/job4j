package ru.job4j.ood.lsp.storing.store;

import ru.job4j.ood.lsp.storing.model.Food;

public class Warehouse extends AbstractStore {

    @Override
    public void add(Food food, Double percentOfShelfLife) {
        if (percentOfShelfLife < 25) {
            findAll().add(food);
        }
    }
}
