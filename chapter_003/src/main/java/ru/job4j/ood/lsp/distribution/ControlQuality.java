package ru.job4j.ood.lsp.distribution;

import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ControlQuality {

    public final List<Store> stores = new ArrayList<>();

    public void add(Store store) {
        stores.add(store);
    }

    private double getPercentOfShelfLife(Food food) {
        Calendar create = food.getCreateDate();
        Calendar expire = food.getExpiryDate();
        Calendar today = Calendar.getInstance();
        double shelfLife = expire.getTimeInMillis() - create.getTimeInMillis();
        double daysOnTheShelf = today.getTimeInMillis() -  create.getTimeInMillis();

        return  (Math.ceil(daysOnTheShelf / shelfLife * 100));
    }

    public void redistribute(Food food) {
        for (Store s : stores) {
            s.add(food, getPercentOfShelfLife(food));
        }
    }

    public void showProductDistribution() {
        for (Store s : stores) {
            System.out.print("Stored in " + s.getClass().getSimpleName() + ": ");
            for (Food f : s.findAll()) {
                System.out.print(f.getName() + " - " + f.getPrice() + "; ");
            }
            System.out.println();
        }
    }
}
