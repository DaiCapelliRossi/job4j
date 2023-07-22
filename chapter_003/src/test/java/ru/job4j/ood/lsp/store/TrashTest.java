package ru.job4j.ood.lsp.store;

import junit.framework.TestCase;
import ru.job4j.ood.lsp.model.Food;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class TrashTest extends TestCase {

    public void testAdd() {
        Store trash = new Trash();
        Food food = new Food("Milk", new GregorianCalendar(2023, Calendar.JULY, 1), new GregorianCalendar(2023, Calendar.JULY, 15), 75, 50);
        double shelfLife = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double daysOnTheShelf = Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double percentage = Math.ceil(daysOnTheShelf / shelfLife * 100);
        trash.add(food, percentage);
        assertThat(trash.findAll(), contains(food));
    }
}