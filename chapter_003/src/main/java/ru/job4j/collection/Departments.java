package ru.job4j.collection;

import java.util.*;

/**
 * Класс - департаменты.
 * Работает со списком департаментов.
 * @author ANASTASIA OSTROUMOVA
 * @version 1.0
 */
public class Departments {

    /**
     * Метод заполняет пропущенные департаменты в заданном списке департаментов.
     * @param deps входящий список департаментов, заданный через коллекцию типа List.
     * @return список, в который были добавлены недостающие департаменты.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + "/" + el);
                start = start + "/" + el;
            }
        }
        List<String> list = new ArrayList<>();
        for (String el : tmp) {
            list.add(el.substring(1));
        }

        return list;
    }

    /**
     * Метод выполняет сортировку по возрастанию.
     * @param orgs входящий список департаментов, заданный через коллекцию типа List.
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Метод выполняет сортировку первых департаментов по убыванию, подчиненные департаменты сортируются по возрастанию.
     * @param orgs входящий список департаментов, заданный через коллекцию типа List.
     */
    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("k2/sk1", "k2/sk1/ssk2", "k1", "k1/sk1/ssk1", "k1/sk2", "k2/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2/ssk1");
        List<String> result = Departments.fillGaps(input);
        sortAsc(result);
        System.out.println("Сортировка по возрастанию:");
        for (String i : result) {
            System.out.println(i);
        }
        sortDesc(result);
        System.out.println("Сортировка по убыванию для первого департамента, по возрастанию для остальных:");
        for (String i : result) {
            System.out.println(i);
        }
    }

}