package ru.sdroman.generator;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.generator.exception.ExtraKeysException;
import ru.sdroman.generator.exception.KeyNotFoundException;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test SimpleGenerator class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class SimpleGeneratorTest {

    /**
     * Keys.
     */
    private Map<String, String> map;

    /**
     * Generator instance.
     */
    private Template generator;

    /**
     * Template.
     */
    private String template;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        generator = new SimpleGenerator();
        template = "Hello, ${name}. How are ${subject}?";
        map = new HashMap<>();
    }

    /**
     * Test generate() method.
     *
     * @throws KeyNotFoundException exception
     * @throws ExtraKeysException   exception
     */
    @Test
    public void whenTakeTextWithDataThenReplaceParamsToData() throws KeyNotFoundException, ExtraKeysException {
        map.put("name", "Ivan");
        map.put("subject", "you");
        final String expected = "Hello, Ivan. How are you?";
        String actual = generator.generate(template, map);
        assertThat(actual, is(expected));
    }

    /**
     * Test generate() method without data.
     *
     * @throws KeyNotFoundException exception
     * @throws ExtraKeysException   exception
     */
    @Test(expected = KeyNotFoundException.class)
    public void whenTakeTextWithoutDataThenKeyNotFoundException() throws KeyNotFoundException, ExtraKeysException {
        map.put("subject", "you");
        generator.generate(template, map);
    }

    /**
     * Test generate() method with extra data.
     *
     * @throws ExtraKeysException   exception
     * @throws KeyNotFoundException exception
     */
    @Test(expected = ExtraKeysException.class)
    public void whenTakeTextWithExtraDataThenExtraKeysException() throws ExtraKeysException, KeyNotFoundException {
        map.put("name", "Ivan");
        map.put("subject", "you");
        map.put("age", "25");
        generator.generate(template, map);
    }
}