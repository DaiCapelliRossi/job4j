package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== All items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        int numerator = 1;
        for (Item item : allItems) {
            System.out.println(numerator + ". Name: " + item.getName() + ", ID: " + item.getId());
            numerator++;
        }
        return true;
    }
}
