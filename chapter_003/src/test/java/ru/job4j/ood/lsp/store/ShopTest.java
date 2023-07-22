package ru.job4j.ood.lsp.store;

import junit.framework.TestCase;
import ru.job4j.ood.lsp.model.Food;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShopTest extends TestCase {

    public void testAdd() {
        Store shop = new Shop();
        Food food = new Food("Milk", new GregorianCalendar(2023, Calendar.JULY, 10), new GregorianCalendar(2023, Calendar.AUGUST, 2), 80, 50);
        double shelfLife = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double daysOnTheShelf = Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double percentage = Math.ceil(daysOnTheShelf / shelfLife * 100);
        shop.add(food, percentage);
        System.out.println(percentage);
        assertThat(shop.findAll(), contains(food));
    }

    public void testWhenLessThan75() {
        Store shop = new Shop();
        Food food = new Food("Milk", new GregorianCalendar(2023, Calendar.JULY, 10), new GregorianCalendar(2023, Calendar.AUGUST, 2), 80, 50);
        double shelfLife = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double daysOnTheShelf = Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double percentage = Math.ceil(daysOnTheShelf / shelfLife * 100);
        shop.add(food, percentage);
        assertThat(shop.findAll().get(0).getPrice(), is(80d));
    }

    public void testWhenMoreThan75() {
        Store shop = new Shop();
        Food food = new Food("Milk", new GregorianCalendar(2023, Calendar.JULY, 10), new GregorianCalendar(2023, Calendar.JULY, 25), 80, 50);
        double shelfLife = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double daysOnTheShelf = Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double percentage = Math.ceil(daysOnTheShelf / shelfLife * 100);
        shop.add(food, percentage);
        assertThat(shop.findAll().get(0).getPrice(), is(40d));
    }
}