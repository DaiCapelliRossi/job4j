package ru.job4j.tracker;

import org.jetbrains.annotations.NotNull;

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

        Item[] namesWithoutNull = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
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
        Item[] namesEqualsKeys = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item name = items[index];
            if (name != null && key.equals(name.getName())) {
                namesEqualsKeys[size] = name;
                size++;
            }
        }
        namesEqualsKeys = Arrays.copyOf(namesEqualsKeys, size);
        return namesEqualsKeys;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(String id) {
        if (indexOf(id) == -1) {
            return null;
        }
        return items[indexOf(id)];
    }

    public boolean replace(String id, Item item) {
        int indexId = indexOf(id);
        item.setId(id);
        items[indexId] = item;
        return true;
    }

    public boolean delete(String id) {
        int i = indexOf(id);
        items[position] = null;
        System.arraycopy(items, i + 1, items, i, position - i);
        position--;
        return true;
    }

}