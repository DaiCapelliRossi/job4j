package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private final Item[] items = new Item[100];

    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item[] findAll() {

        Item[] namesWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null) {
                namesWithoutNull[size] = name;
                size++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, size);
        return namesWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] namesEqualsKeys = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null && key.equals(name.getName())) {
                namesEqualsKeys[size] = name;
                size++;
            }
        }
        namesEqualsKeys = Arrays.copyOf(namesEqualsKeys, size);
        return namesEqualsKeys;
    }

    public Item findById(String id) {
        Item x;
        for (int index = 0; index < this.items.length; index++) {
            if (items[index].getId().equals(id)) {
                x = items[index];
                return x;
            }
        }
        return null;
    }
}