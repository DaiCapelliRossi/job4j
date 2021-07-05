package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {

        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23),
                new Attachment("images 21", 23)
        };

        Comparator<Attachment> cmpDescText = (left, right) -> {
            System.out.println("Compare - " + right.getName() + " : " + left.getName());
            return right.getName().compareTo(left.getName());
        };

        Arrays.sort(atts, cmpDescText);
        System.out.println("По убыванию");
        for (Attachment a : atts) {
            System.out.println(a);
        }

    }
}
