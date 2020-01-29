package ru.job4j.tracker;

public class Tiger extends Predator {

    public Tiger() {
    }

    public Tiger(String kingdom, String group, String name) {
        super(kingdom, group);
        this.name = name;
    }
}
