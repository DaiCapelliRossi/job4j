package ru.job4j.tracker;

public class Predator extends Animal {

    public Predator() {
    }

    public Predator(String kingdom, String group) {
        super(kingdom);
        this.group = group;
    }
}
