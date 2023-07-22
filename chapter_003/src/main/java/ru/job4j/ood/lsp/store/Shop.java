package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

public class Shop extends AbstractStore {

    @Override
    public void add(Food food, Double percentOfShelfLife) {
        if (percentOfShelfLife >= 25 && percentOfShelfLife < 75) {
            findAll().add(food);
        } else if (percentOfShelfLife >= 75 && percentOfShelfLife <= 100) {
            food.setPrice(food.getPrice() * ((100 - food.getDiscount()) / 100));
            findAll().add(food);
            food.setName(food.getName() + " (on sale)");
        }
    }
}
