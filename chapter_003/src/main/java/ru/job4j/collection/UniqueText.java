package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        Collections.addAll(check, origin);
        for (String s : text) {
            if (!check.contains(s)) {
                return false;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        UniqueText t = new UniqueText();
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        boolean x = isEquals(origin, text);
        System.out.println(x);
    }
}
