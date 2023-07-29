package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class SimpleMenuPrinter implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo item : menu) {
            String number = item.getNumber();
            String numberWODots = number.replaceAll("\\.", "");
            int n = number.length() - numberWODots.length();
            for (int i = 0; i < n - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(item.getNumber() + item.getName());
        }
    }
}
