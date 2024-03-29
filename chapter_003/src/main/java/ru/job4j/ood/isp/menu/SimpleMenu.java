package ru.job4j.ood.isp.menu;

import java.util.*;

public class SimpleMenu implements Menu {

    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        Optional<ItemInfo> parentInfo = findItem(parentName);
        MenuItem item = new SimpleMenuItem(childName, actionDelegate);
        if (parentInfo.isEmpty()) {
            rootElements.add(item);
        }
        parentInfo.ifPresent(itemInfo -> itemInfo.menuItem.getChildren().add(item));

        return true;
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        Optional<ItemInfo> itemInfo = findItem(itemName);
        MenuItemInfo menuItemInfo = null;
        if (itemInfo.isPresent()) {
            menuItemInfo = new MenuItemInfo(itemInfo.get().menuItem, itemInfo.get().number);
        }
        return Optional.ofNullable(menuItemInfo);
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        return new MenuItemInfoIterator();
    }

    private class MenuItemInfoIterator implements Iterator<MenuItemInfo> {

        private DFSIterator dfsIterator;

        MenuItemInfoIterator() {
            dfsIterator = new DFSIterator();
        }

        @Override
        public boolean hasNext() {
            return dfsIterator.hasNext();
        }

        @Override
        public MenuItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ItemInfo itemInfo = dfsIterator.next();
            return new MenuItemInfo(itemInfo.menuItem, itemInfo.number);
        }
    }

    private Optional<ItemInfo> findItem(String name) {
        ItemInfo itemInfo = null;
        DFSIterator dfsIterator = new DFSIterator();
        while (dfsIterator.hasNext()) {
            ItemInfo nextElem = dfsIterator.next();
            if (nextElem.menuItem.getName().equals(name)) {
                itemInfo = nextElem;
            }
        }
        return Optional.ofNullable(itemInfo);
    }

    private static class SimpleMenuItem implements MenuItem {

        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious(); ) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
            }
            return new ItemInfo(current, lastNumber);
        }
    }

    private class ItemInfo {
        MenuItem menuItem;
        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }

}
