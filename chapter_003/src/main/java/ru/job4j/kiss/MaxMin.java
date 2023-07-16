package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findValue(value, (t, t2) -> comparator.compare(t, t2) > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findValue(value, (t, t2) -> comparator.compare(t, t2) < 0);
    }

    public <T> T findValue(List<T> value, BiPredicate<T, T> biPredicate) {
        if (value.isEmpty()) {return null;}
        T temp = value.get(0);
        for (T t : value) {
            if(biPredicate.test(t, temp)) {
                temp = t;
            }
        }
        return temp;
    }
}