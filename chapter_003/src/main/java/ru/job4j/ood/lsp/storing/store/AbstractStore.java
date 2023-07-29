package ru.job4j.ood.lsp.storing.store;

import ru.job4j.ood.lsp.storing.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractStore implements Store {

    private final List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food, Double percentOfShelfLife) {
        foods.add(food);
    }

    @Override
    public List<Food> findAll() {
        return foods;
    }

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return foods.stream().filter(filter).collect(Collectors.toList());
    }
    @Override
    public List<Food> pickUpAll() {
        List<Food> list = new ArrayList<>(this.foods);
        this.foods.clear();
        return list;
    }
}
