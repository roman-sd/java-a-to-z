package ru.sdroman.findFiles;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MenuTest.
 *
 * @author sdroman
 * @version 0.1
 * @since 13.02.17
 */
public class MenuTest {

    /**
     * Test Menu class  - false.
     *
     * @throws IOException exception
     */
    @Test
    public void menuFailed() throws IOException {
        String[] args = {"-d", "C:\\", "-n", "test.txt", "-g", "-o", "log.txt"};
        Menu menu = new Menu(args);
        boolean actual = menu.find();
        assertThat(actual, is(false));
    }

    /**
     * Test Menu class - true.
     *
     * @throws IOException exception
     */
    @Test
    public void menuTrue() throws IOException {
        String[] args = {"-d", "e:\\", "-n", "*.pdf", "-m", "-o", "log.txt"};
        Menu menu = new Menu(args);
        boolean actual = menu.find();
        assertThat(actual, is(true));
    }
}
