package ru.job4j.tracker;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());

            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("ID for this item: " + item.getId());

            } else if (select == 1) {
                System.out.println("=== All items ===");
                Item[] allItems = tracker.findAll();
                int numerator = 1;
                for (Item item : allItems) {
                    System.out.println(numerator + ". Name: " + item.getName() + ", ID: " + item.getId());
                    numerator++;
                }

            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Enter ID of an element you want to change: ");
                String id = scanner.nextLine();
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Item was successfully changed.");
                } else {
                    System.out.println("Something went wrong. Try again.");
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println("Enter ID of an element you want to delete: ");
                String idDelete = scanner.nextLine();
                if (tracker.delete(idDelete)) {
                    System.out.println("Item was successfully deleted.");
                } else {
                    System.out.println("Something went wrong. Try again.");
                }

            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.println("Enter ID: ");
                String id = scanner.nextLine();
                Item itemById = tracker.findById(id);
                System.out.println("Name: " + itemById.getName());

            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                System.out.println("Enter name: ");
                String findName = scanner.nextLine();
                Item[] findItems = tracker.findByName(findName);
                for (Item item : findItems) {
                    System.out.println("Name: " + item.getName() + ", ID: " + item.getId());
                }

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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
