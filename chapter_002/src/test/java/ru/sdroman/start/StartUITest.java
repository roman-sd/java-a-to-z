package ru.sdroman.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.sdroman.models.Item;

/**
 * Test class for StartUI.
 */
public class StartUITest {

    /**
     * Test for 1 in menu.
     */
    @Test
    public void whenSetOneThenAdd() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "item1", "desc1", "7"});
        new StartUI(input).init(tracker);
        assertThat(tracker.getAll()[0].getName(), is("item1"));
    }

    /**
     * Test for 2 in menu.
     */
    @Test
    public void whenSetTwoThenEdit() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "item1", "desc1", "2", "item1", "newItem", "newDesc", "7"});
        new StartUI(input).init(tracker);
        assertThat(tracker.getAll()[0].getName(), is("newItem"));
    }

    /**
     * Test for 3 in menu.
     */
    @Test
    public void whenSetThreeThenRemoveItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "item1", "desc1", "3", "item1", "7"});
        new StartUI(input).init(tracker);
        assertThat(tracker.getAll(), is(new Item[]{}));
    }

    /**
     * Test for 4 in menu.
     */
    @Test
    public void whenSetFourThenFindByName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "item1", "desc1", "4", "item1", "7"});
        new StartUI(input).init(tracker);
        assertThat(tracker.findByName("item1").getName(), is("item1"));
    }

    /**
     * Test for 5 in menu.
     */
    @Test
    public void whenSetFiveThenFindById() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("item1", "desc1"));
        tracker.add(new Item("item2", "desc2"));
        String str = tracker.findByName("item2").getId();
        Input input = new StubInput(new String[]{"5", str, "7"});
        new StartUI(input).init(tracker);
        assertThat(tracker.findById(str).getName(), is("item2"));
    }

    /**
     * Test for 6 in menu.
     */
    @Test
    public void whenSetSixThenGetAll() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("item1", "desc1"));
        Item item2 = tracker.add(new Item("item2", "desc2"));
        Item item3 = tracker.add(new Item("item3", "desc3"));
        Item[] items = new Item[]{item1, item2, item3};
        Input input = new StubInput(new String[]{"6", "7"});
        new StartUI(input).init(tracker);
        assertThat(tracker.getAll(), is(items));
    }
}
