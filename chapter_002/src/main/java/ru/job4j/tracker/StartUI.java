package ru.job4j.tracker;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("ID for this item: " + item.getId());
    }

    public static void allItems(Input input, Tracker tracker) {
        System.out.println("=== All items ===");
        Item[] allItems = tracker.findAll();
        int numerator = 1;
        for (Item item : allItems) {
            System.out.println(numerator + ". Name: " + item.getName() + ", ID: " + item.getId());
            numerator++;
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID of an element you want to change: ");
        String name = input.askStr("Enter new name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Item was successfully changed.");
        } else {
            System.out.println("Something went wrong. Try again.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        String idDelete = input.askStr("Enter ID of an element you want to delete: ");
        if (tracker.delete(idDelete)) {
            System.out.println("Item was successfully deleted.");
        } else {
            System.out.println("Something went wrong. Try again.");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        String id = input.askStr("Enter ID: ");
        Item itemById = tracker.findById(id);
        System.out.println("Name: " + itemById.getName());
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ===");
        String findName = input.askStr("Enter name: ");
        Item[] findItems = tracker.findByName(findName);
        for (Item item : findItems) {
            System.out.println("Name: " + item.getName() + ", ID: " + item.getId());
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.allItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                System.out.println("=== Exit program ===");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}