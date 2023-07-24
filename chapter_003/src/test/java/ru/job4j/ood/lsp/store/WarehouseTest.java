package ru.job4j.ood.lsp.store;

import junit.framework.TestCase;
import ru.job4j.ood.lsp.storing.model.Food;
import ru.job4j.ood.lsp.storing.store.Store;
import ru.job4j.ood.lsp.storing.store.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class WarehouseTest extends TestCase {

    public void testAdd() {
        Store wh = new Warehouse();
        Food food = new Food("Milk", new GregorianCalendar(2023, Calendar.JULY, 21), new GregorianCalendar(2023, Calendar.AUGUST, 15), 75, 50);
        double shelfLife = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double daysOnTheShelf = Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double percentage = Math.ceil(daysOnTheShelf / shelfLife * 100);
        wh.add(food, percentage);
        assertThat(wh.findAll(), contains(food));
    }
}