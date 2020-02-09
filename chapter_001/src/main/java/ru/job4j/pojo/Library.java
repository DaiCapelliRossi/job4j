package ru.job4j.pojo;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Library {
    public static void main(String[] args) {
        Book a = new Book("Sapiens: A Brief History of Humankind", 443);
        Book b = new Book("Harry Potter and the Philosopher's Stone", 223);
        Book c = new Book("Clean book", 0);
        Book d = new Book("Gone with the wind", 1037);

        Book[] books = new Book[4];

        books[0] = a;
        books[1] = b;
        books[2] = c;
        books[3] = d;

        for (int i = 0; i < books.length; i++) {
            Book reading = books[i];
            System.out.println(reading.getName() + " - " + reading.getPage() + " pages");
        }
        System.out.println("Swap books a and d:");
        Book booksTemp = books[0];
        books[0] = books[3];
        books[3] = booksTemp;

        for (int i = 0; i < books.length; i++) {
            Book reading = books[i];
            System.out.println(reading.getName() + " - " + reading.getPage() + " pages");
        }
        System.out.println("Show books named 'Clean name':");

        for (int i = 0; i < books.length; i++) {
            Book reading = books[i];
            if (books[i].getName() == "Clean book") {
                System.out.println(reading.getName() + " - " + reading.getPage() + " pages");
            }
        }
    }
}
