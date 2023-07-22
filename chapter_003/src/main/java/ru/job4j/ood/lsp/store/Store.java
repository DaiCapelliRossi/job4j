package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    void add(Food food, Double percentOfShelfLife);

    List<Food> findAll();

    List<Food> findBy(Predicate<Food> filter);
}
