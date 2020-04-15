package ru.job4j.io;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        int player = 1;
        System.out.println("There are now 11 matches on the table.");
        System.out.println("Choose who's gonna be player 1 and who's gonna be player 2.");
        System.out.println("Game starts with player 1.");
        System.out.println("In his turn player needs to choose to take 1, 2 or 3 matches.");
        System.out.println("Player who takes the last matches wins.");
        while (matches > 0) {
            System.out.println("Player " + player + " makes his move.");
            System.out.println("Enter a number between 1 and 3:");
            int select = Integer.valueOf(input.nextLine());
            if (select > 3 || select <= 0) {
                System.out.println("This is an invalid number. Try again.");
                continue;
            }
            matches = matches - select;
            if (matches > 0) {
                System.out.println("There remains " + (matches) + " matches on the table.");
                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            } else {
                System.out.println("There is no matches on the table. Player " + player + " wins! Congrats!!!");
            }
        }
        System.out.println();
    }
}

