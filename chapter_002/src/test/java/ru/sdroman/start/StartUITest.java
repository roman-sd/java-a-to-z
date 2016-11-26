package ru.sdroman.start;

import org.junit.Test;
import ru.sdroman.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        Input input = new StubInput(new String[]{"1", "item1", "desc1", "y"});
        new StartUI(input).init(tracker);
        assertThat(tracker.getAll()[0].getName(), is("item1"));
    }

    /**
     * Test for 2 in menu.
     */
    @Test
    public void whenSetTwoThenEdit() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item", "desc"));
        Input input = new StubInput(new String[]{"2", "item", "newItem", "newDesc", "y"});
        new StartUI(input).init(tracker);
        assertThat(tracker.getAll()[0].getName(), is("newItem"));
    }

    /**
     * Test for 3 in menu.
     */
    @Test
    public void whenSetThreeThenRemoveItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "item1", "desc1", "n", "3", "item1", "y"});
        new StartUI(input).init(tracker);
        assertThat(tracker.getAll(), is(new Item[]{}));
    }

    /**
     * Test for 4 in menu.
     */
    @Test
    public void whenSetFourThenFindByName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "item1", "desc1", "n", "4", "item1", "y"});
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
        Input input = new StubInput(new String[]{"5", str, "y"});
        new StartUI(input).init(tracker);
        assertThat(tracker.findById(str).getName(), is("item2"));
    }

    /**
     * Test for 6 in menu.
     */
    @Test
    public void whenSetSixThenAddComment() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"6", "name", "testComment", "y"});
        new StartUI(input).init(tracker);
        assertThat(item.getComments()[0].getComment(), is("testComment"));
    }

    /**
     * Test for 7 in menu.
     */
    @Test
    public void whenSetSevenThenGetAll() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("item1", "desc1"));
        Item item2 = tracker.add(new Item("item2", "desc2"));
        Item item3 = tracker.add(new Item("item3", "desc3"));
        Item[] items = new Item[]{item1, item2, item3};
        Input input = new StubInput(new String[]{"7", "y"});
        new StartUI(input).init(tracker);
        assertThat(tracker.getAll(), is(items));
    }
}
