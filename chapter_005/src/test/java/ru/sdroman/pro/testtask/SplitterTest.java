package ru.sdroman.pro.testtask;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SplitterTest.
 *
 * @author sdroman
 * @since 07.2017
 */
public class SplitterTest {

    /**
     * FileName.
     */
    private static final String FILENAME = "src\\test\\java\\ru\\sdroman\\resources\\orderTest.xml";

    /**
     * Parser.
     */
    private Splitter splitter = new Splitter();

    /**
     * Test parse() method.
     */
    @Test
    public void whenTakeFileThenReturnMap() {
        Map<Integer, Order> expectedMap = new HashMap<>();
        expectedMap.put(2, new Order("book-1", "BUY", 102.0, 200, 2));
        expectedMap.put(4, new Order("book-1", "BUY", 104.0, 400, 4));
        expectedMap.put(5, new Order("book-1", "SELL", 105.0, 500, 5));
        expectedMap.put(7, new Order("book-1", "BUY", 102.0, 100, 7));
        expectedMap.put(8, new Order("book-1", "SELL", 107.0, 50, 8));

        Map<Integer, Order> map = splitter.parse(FILENAME);

        assertThat(map, is(expectedMap));
    }
}
