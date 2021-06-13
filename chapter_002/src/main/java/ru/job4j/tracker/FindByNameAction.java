package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String findName = input.askStr("Enter name: ");
        List<Item> findItems = tracker.findByName(findName);
        for (Item item : findItems) {
            System.out.println("Name: " + item.getName() + ", ID: " + item.getId());
        }
        return true;
    }
}
