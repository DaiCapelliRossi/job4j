package ru.job4j.ood.isp.user;

import ru.job4j.ood.isp.menu.*;

import java.util.*;

public class TodoApp {
    static ActionDelegate DEFAULT_ACTION = () -> System.out.println("Some action");

    public static final String MENU = """
            Введите 1 для добавления задачи в корень меню;
            Введите 2 для добавления задачи к родительской задаче;
            Введите 3 для вызова действие, привязанного к пункту меню;
            Введите 4 для вывода меню в консоль;
            Введите любое другое число для выхода из программы.
            """;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new SimpleMenu();
        while (true) {
            boolean run = true;
            while (run) {
                System.out.println(MENU);
                System.out.println("Введите число:");
                int userChoice = Integer.parseInt(scanner.nextLine());
                System.out.println(userChoice);
                if (1 == userChoice) {
                    System.out.println("Введите название новой задачи для добавления в корень меню");
                    String text = scanner.nextLine();
                    menu.add(Menu.ROOT, text, DEFAULT_ACTION);
                } else if (2 == userChoice) {
                    System.out.println("Введите название задачи, к которой будет добавлена новая задача");
                    String text = scanner.nextLine();
                    System.out.println("Введите название новой задачи");
                    String text2 = scanner.nextLine();
                    menu.add(text, text2, DEFAULT_ACTION);
                } else if (3 == userChoice) {
                    System.out.println("Введите название файла, чтобы вызвать его действие");
                    String text = scanner.nextLine();
                    menu.select(text);
                    System.out.println(DEFAULT_ACTION);
                } else if (4 == userChoice) {
                    MenuPrinter simpleMenuPrinter = new SimpleMenuPrinter();
                    simpleMenuPrinter.print(menu);
                    System.out.println();
                } else {
                    run = false;
                    System.out.println("Выход");
                }
            }
        }
    }

}
