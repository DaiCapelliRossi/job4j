package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        int index = 0;
        for (String el : value) {
            if (el.equals(key)) {
                rsl = index;
                System.out.println(key + " has index of " + rsl);
                break;
            }
            index++;
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"key", "car", "house"}, "car");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}