package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23),
                new Attachment("images 21", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();

        Comparator<Attachment> cmpSize = (left, right) -> left.getName().length() - right.getName().length();

        Comparator<Attachment> cmpText = (left, right) -> left.getName().compareTo(right.getName());

        Comparator<Attachment> cmpDescSize = (left, right) -> right.getName().length() - left.getName().length();

        Arrays.sort(atts, comparator);
        System.out.println("По длине массива");
        for (Attachment a : atts) {
            System.out.println(a);
        }
        Arrays.sort(atts, cmpSize);
        System.out.println("По длине строк");
        for (Attachment a : atts) {
            System.out.println(a);
        }
        Arrays.sort(atts, cmpText);
        System.out.println("По возрастанию");
        for (Attachment a : atts) {
            System.out.println(a);
        }
        Arrays.sort(atts, cmpDescSize);
        System.out.println("По убыванию длины строк");
        for (Attachment a : atts) {
            System.out.println(a);
        }
    }

}