package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        for (int i = word.length - post.length; i < word.length; i++) {
            if (word[i] != post[i - (word.length - post.length)]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        // проверить. что массив word имеет последние элементы одинаковые с post
        return result;
    }
}
