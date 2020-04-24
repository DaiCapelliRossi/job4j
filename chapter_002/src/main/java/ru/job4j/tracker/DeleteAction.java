package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idDelete = input.askStr("Enter ID of an element you want to delete: ");
        if (tracker.delete(idDelete)) {
            System.out.println("Item was successfully deleted.");
        } else {
            System.out.println("Something went wrong. Try again.");
        }
        return true;
    }
}
