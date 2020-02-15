package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenAddNewItemThenTrackerFindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findAll();
        Item[] items = {item, item2, item3};
        assertThat(result, is(items));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItemName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item);
        tracker.add(item2);
        Item[] items = {item};
        Item[] result = tracker.findByName("test1");
        assertThat(result, is(items));
    }
}