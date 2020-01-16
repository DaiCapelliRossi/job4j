package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result;
        boolean maximum = first > second;
        if (maximum) {
            maximum = first > third;
            result = maximum ? first : third;
        } else {
            maximum = second > third;
            result = maximum ? second : third;
        }
        return result;
    }
}
