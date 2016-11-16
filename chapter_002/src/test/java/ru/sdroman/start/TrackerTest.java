package ru.sdroman.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.sdroman.models.Item;

/**
 * class for testing Tracker.
 */
public class TrackerTest {

    /**
     * test add().
     */
    @Test
    public void whenAddThenAddItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Smirnov", "desc009");
        assertThat(tracker.add(item), is(item));
    }

    /**
     * test findById().
     */
    @Test
    public void whenFindByIdThenFindItemById() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Ivanov", "desc001"));
        tracker.add(new Item("Petrov", "desc002"));
        Item testItem = tracker.add(new Item("Sidorov", "desc003"));
        String id = testItem.getId();
        assertThat(tracker.findById(id), is(testItem));
    }

    /**
     * test findByName().
     */
    @Test
    public void whenFindByNameThenFindItemByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Ivanov", "desc001"));
        tracker.add(new Item("Petrov", "desc002"));
        Item testItem = tracker.add(new Item("Sidorov", "desc003"));
        String name = testItem.getName();
        assertThat(tracker.findByName(name), is(testItem));
    }

    /**
     * test edit().
     */
    @Test
    public void whenEditThenEditItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Ivanov", "desc001"));
        Item item = tracker.add(new Item("Petrov", "desc002"));
        tracker.add(new Item("Sidorov", "desc003"));
        Item testItem = new Item("Bond", "007");
        String id = item.getId();
        testItem.setId(id);
        tracker.edit(testItem);
        assertThat(tracker.findById(id), is(testItem));
    }

    /**
     * test GetAll().
     */
    @Test
    public void whenGetAllThenGetAllItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Ivanov", "desc001"));
        Item item2 = tracker.add(new Item("Petrov", "desc002"));
        Item item3 = tracker.add(new Item("Sidorov", "desc003"));
        Item[] items = new Item[]{item1, item2, item3};
        assertThat(tracker.getAll(), is(items));
    }

    /**
     * test remove().
     */
    @Test
    public void whenRemoveThenRemoveItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Ivanov", "desc001"));
        Item testItem = tracker.add(new Item("Petrov", "desc002"));
        Item item2 = tracker.add(new Item("Sidorov", "desc003"));
        Item[] items = new Item[]{item1, item2};
        tracker.remove(testItem);
        assertThat(tracker.getAll(), is(items));
    }
}
