package ru.job4j.encapsulation;

public class Config {
    private String name; //1
    private int position; //2
    public String[] properties;

    public Config(String name) {
        this.name = name;
    }

    public void print() { //3
        System.out.println(position);
    }

    public String getProperty(String key) { //4
        return search(key);
    }

    public String search(String key) { //5
        return key;
    }
}
