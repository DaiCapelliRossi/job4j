package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите кэшируемую директорию");
        String directory = scanner.nextLine();
        DirFileCache dirFileCache = new DirFileCache(directory);

        boolean run = true;
        while (run) {
            System.out.println("Введите название файла или напишите Стоп для остановки");
            String fileName = scanner.nextLine();
            if (fileName.equals("Стоп")) {
                run = false;
                System.out.println("Выход");
            } else {
                System.out.println(dirFileCache.get(fileName));
            }
        }
    }
}

//C:\Users\nesso\Desktop\
//text1.txt


