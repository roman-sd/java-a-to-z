package ru.sdroman.start;

import ru.sdroman.models.Item;

/**
 * class StartUI.
 */
public class StartUI {
    /**
     * main().
     * @param args String[]
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Ivanov", "desc001"));
        Item item2 = tracker.add(new Item("Sidorov", "desc002"));
        Item item3 = tracker.add(new Item("Petrov", "desc003"));
        Item testItem = new Item("Bond", "desc007");
        testItem.setId(item2.getId());
        tracker.edit(testItem);
        for (Item item : tracker.getAll()) {
            System.out.println(String.format("%s %s ", item.getName(), item.getDescription()));
        }
    }
}
