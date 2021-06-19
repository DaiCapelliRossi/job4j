package ru.job4j.solutions;

public class Solution {
    public static void main(String[] args) {
        Pegasus horse = new Pegasus();
    }
    public static interface CanFly {
        public void fly();
    }
    public static class Horse {
        public void run() {
        }
    }
    public static class Pegasus {
    }
}
