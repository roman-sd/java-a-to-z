package ru.sdroman.start;

import org.junit.Test;
import ru.sdroman.models.Comment;
import ru.sdroman.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
     * test ItemNotFoundException in findById().
     */
    @Test(expected = ItemNotFoundException.class)
    public void whenFindByIdThenFindByIdException() {
        Tracker tracker = new Tracker();
        tracker.findById("exception");
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
     * test ItemNotFoundException in findById().
     */
    @Test(expected = ItemNotFoundException.class)
    public void whenFindByNameThenFindByNameException() {
        Tracker tracker = new Tracker();
        tracker.findByName("exception");
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
     * test ItemNotFoundException in edit().
     */
    @Test(expected = ItemNotFoundException.class)
    public final void whenEditThenEditItemException() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("item", "desc001"));
        tracker.edit(new Item("testItem", "desc001"));
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

    /**
     * test ItemNotFoundException in remove().
     */
    @Test(expected = ItemNotFoundException.class)
    public void whenRemoveThenRemoveItemException() {
        Tracker tracker = new Tracker();
        tracker.remove(new Item("item", "desc"));
    }

    /**
     * test addComment.
     */
    @Test
    public void whenAddCommentThenAddComment() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item", "desc"));
        Comment comment = new Comment("testComment");
        item.addComment(comment);
        assertThat(item.getComments()[0], is(comment));
    }

    /**
     * test ItemNotFoundException in addComment().
     */
    @Test(expected = ItemNotFoundException.class)
    public void whenAddCommentThenAddCommentException() {
        Tracker tracker = new Tracker();
        tracker.addComment(new Comment("testComment"), "testId");
    }
}
