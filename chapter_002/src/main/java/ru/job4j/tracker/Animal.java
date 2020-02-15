package ru.job4j.tracker;

public class Animal {

    String kingdom;
    String group;
    String name;

    public Animal() {
    }

    public Animal(String kingdom) {
        this.kingdom = kingdom;
    }

    public static void main(String[] args) {

        Animal c = new Tiger("Animal", "Predator", "Tiger");
        System.out.println(c.kingdom);
        System.out.println(c.group);
        System.out.println(c.name);

    }
}
