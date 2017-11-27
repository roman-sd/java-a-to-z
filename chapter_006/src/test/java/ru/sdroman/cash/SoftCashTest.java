package ru.sdroman.cash;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sdroman
 * @since 11.2017
 */
public class SoftCashTest {

    /**
     * Separator.
     */
    private static final String LS = System.getProperty("line.separator");

    /**
     * Path.
     */
    private String path = SoftCash.class.getResource("/").getPath();

    /**
     * Cash.
     */
    private SoftCash softCash = new SoftCash(path);

    /**
     * Test get() method.
     */
    @Test
    public void whenGetValueThenLoadDataAndReturnCash() {
        String key = "Names.txt";
        String expected = "Scarlett Johansson" + LS
                + "Alice Braga" + LS
                + "Molly Quinn" + LS;

        String actual = softCash.get(key);
        assertThat(actual, is(expected));
    }

    /**
     * Test get() method.
     */
    @Test
    public void whenGetValueThenReturnDataFromCash() {
        String key = "Address.txt";
        String expected = "12345" + LS
                + "54321" + LS
                + "7890" + LS;
        softCash.get(key);
        String actual = softCash.getData(key);
        assertThat(actual, is(expected));
    }
}