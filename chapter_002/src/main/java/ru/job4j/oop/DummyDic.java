package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String unknown = "Неизвестное слово " + eng;
        return unknown;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String translate = word.engToRus("bord");
        System.out.println(translate);
    }
}
