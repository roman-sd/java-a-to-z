package ru.sdroman.menu;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Node class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class NodeTest {

    /**
     * Menu.
     */
    private Menu menu;

    /**
     * SetUp.
     */
    @Before
    public void setUp() {
        menu = new Menu();
    }

    /**
     * Test add() method.
     */
    @Test
    public void whenAddNodeThenAddToArray() {
        Node rootMenu1 = new Node("1", "Root1");
        Node submenu1 = new Node("1.1", "submenu1");
        Node submenu2 = new Node("1.2", "submenu2");
        Node submenu3 = new Node("1.3", "submenu3");
        rootMenu1.add(submenu1);
        rootMenu1.add(submenu2);
        rootMenu1.add(submenu3);
        Node[] actual = rootMenu1.getNodes();
        Node[] expected = {submenu1, submenu2, submenu3};
        assertThat(actual, is(expected));
    }

    /**
     * Test add() method.
     */
    @Test
    public void whenAddNodeThenGrowArray() {
        final Node rootMenu = new Node("1", "Root1");
        final Node submenu1 = new Node("1.1", "submenu1");
        final Node submenu2 = new Node("1.2", "submenu2");
        final Node submenu3 = new Node("1.3", "submenu3");
        final Node submenu4 = new Node("1.4", "submenu4");
        rootMenu.add(submenu1);
        rootMenu.add(submenu2);
        rootMenu.add(submenu3);
        rootMenu.add(submenu4);
        final int actual = rootMenu.getNodes().length;
        final int expected = 4;
        assertThat(actual, is(expected));
    }

    /**
     * Test printNode() method.
     * @exception IOException exception
     */
    @Test
    public void whenShowMenuThenPrintNodes() throws IOException {
        final Node rootMenu1 = new Node("1", "Root1");
        final Node rootMenu2 = new Node("2", "Root2");
        final Node submenu1 = new Node("1.1", "submenu1");
        final Node submenu2 = new Node("2.1", "submenu2");
        rootMenu1.add(submenu1);
        rootMenu2.add(submenu2);
        final String separator = System.getProperty("line.separator");
        final String expected = "1.Root1" + separator
                + "--1.1.submenu1" + separator
                + "2.Root2" + separator
                + "--2.1.submenu2" + separator;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        menu.showMenu(new Node[]{rootMenu1, rootMenu2});
        assertThat(out.toString(), is(expected));
        out.close();
    }
}