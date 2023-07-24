package ru.job4j.ood.lsp.distribution;

import junit.framework.TestCase;
import ru.job4j.ood.lsp.storing.model.Food;
import ru.job4j.ood.lsp.storing.store.Shop;
import ru.job4j.ood.lsp.storing.store.Trash;
import ru.job4j.ood.lsp.storing.store.Warehouse;
import ru.job4j.ood.lsp.storing.distribution.ControlQuality;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest extends TestCase {

    public void testRedistribute() {
        List<Food> foods = List.of(
                new Food("Bread", new GregorianCalendar(2023, Calendar.JULY, 15), new GregorianCalendar(2023, Calendar.AUGUST, 2), 20, 20),
                new Food("Milk", new GregorianCalendar(2023, Calendar.JULY, 21), new GregorianCalendar(2023, Calendar.JULY, 28), 75, 50),
                new Food("Ice Cream", new GregorianCalendar(2022, Calendar.JULY, 21), new GregorianCalendar(2023, Calendar.JULY, 20), 100, 15),
                new Food("Eggs", new GregorianCalendar(2023, Calendar.JUNE, 21), new GregorianCalendar(2023, Calendar.JULY, 25), 90, 10),
                new Food("Tomato", new GregorianCalendar(2023, Calendar.MAY, 31), new GregorianCalendar(2023, Calendar.JUNE, 31), 50, 25),
                new Food("Cookie", new GregorianCalendar(2022, Calendar.SEPTEMBER, 21), new GregorianCalendar(2023, Calendar.SEPTEMBER, 21), 150, 5),
                new Food("Cucumber", new GregorianCalendar(2023, Calendar.JULY, 21), new GregorianCalendar(2023, Calendar.AUGUST, 21), 10, 30),
                new Food("Avocado", new GregorianCalendar(2023, Calendar.JUNE, 22), new GregorianCalendar(2023, Calendar.JULY, 23), 200, 40)
        );

        ControlQuality controlQuality = new ControlQuality();

        controlQuality.add(new Warehouse());
        controlQuality.add(new Shop());
        controlQuality.add(new Trash());

        for (Food f : foods) {
            controlQuality.redistribute(f);
        }

        List<Food> testWH = List.of(
                new Food("Milk", new GregorianCalendar(2023, Calendar.JULY, 21), new GregorianCalendar(2023, Calendar.JULY, 28), 75, 50),
                new Food("Cucumber", new GregorianCalendar(2023, Calendar.JULY, 21), new GregorianCalendar(2023, Calendar.AUGUST, 21), 10, 30)
        );

        List<Food> redistributedFood = controlQuality.stores.get(0).findAll();

        for(int i = 0; i < redistributedFood.size(); i++) {
            assertThat((redistributedFood.get(i)), is(testWH.get(i)));
        }
    }
}