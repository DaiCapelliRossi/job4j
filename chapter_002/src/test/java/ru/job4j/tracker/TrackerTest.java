package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {

    @Test
    public void sortByID() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("c");
        Item item2 = new Item("a");
        Item item3 = new Item("b");
        items.add(item1);
        items.add(item2);
        items.add(item3);

        Collections.sort(items, new ItemCompareAscending());
        String[] sortedItems = new String[3];
        for (int i = 0; i < 3; i++) {
            sortedItems[i] = items.get(i).getName();
        }

        assertThat(sortedItems, is(new String[]{"a", "b", "c"}));
    }

    @Test
    public void sortByIDReverse() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("c");
        Item item2 = new Item("a");
        Item item3 = new Item("b");
        items.add(item1);
        items.add(item2);
        items.add(item3);

        Collections.sort(items, new ItemCompareDescending());

        String[] sortedItems = new String[3];
        for (int i = 0; i < 3; i++) {
            sortedItems[i] = items.get(i).getName();
        }

        assertThat(sortedItems, is(new String[]{"c", "b", "a"}));
    }


/*
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

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item butterfly = new Item("Butterfly");
        tracker.add(bug);
        tracker.add(butterfly);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    private Object nullValue() {
        return null;
    }

 */
}
