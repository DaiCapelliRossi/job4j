package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== All items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> allItems = tracker.findAll();
        int numerator = 1;
        for (Item item : allItems) {
            System.out.println(numerator + ". Name: " + item.getName() + ", ID: " + item.getId());
            numerator++;
        }
        return true;
    }
}
