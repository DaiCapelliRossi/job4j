package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {

    private final List<Item> items = new ArrayList<Item>() {
    };

    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public List<Item> findAll() {

        List<Item> namesWithoutNull = new ArrayList<Item>();
        for (Item item : items) {
            Item name = item;
            if (name != null) {
                namesWithoutNull.add(item);
            }
        }
        return namesWithoutNull;
    }

    public List<Item> findByName(String key) {
        List<Item> namesEqualsKeys = new ArrayList<Item>();
        for (Item item : items) {
            Item name = item;
            if (name != null && key.equals(name.getName())) {
                namesEqualsKeys.add(name);
            }
        }
        return namesEqualsKeys;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
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
        return items.get(indexOf(id));
    }

    public boolean replace(String id, Item item) {
        int indexId = indexOf(id);
        if (indexId == -1) {
            return false;
        } else {
            item.setId(id);
            items.set(indexId, item);
            return true;
        }
    }

    public boolean delete(String id) {
        int i = indexOf(id);
        if (i == -1) {
            return false;
        } else {
            items.remove(i);
            return true;
        }
    }

}