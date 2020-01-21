package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare hare = new Hare();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();

        kolobok.tryEat(kolobok);
        hare.tryEat(kolobok);
        fox.tryEat(kolobok);
        wolf.tryEat(kolobok);
    }
}
