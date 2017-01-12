package ru.sdroman;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class CheckInput.
 *
 * @author sdroman
 * @version 1.0
 * @since 11.01.17
 */
public class CheckInputTest {

    /**
     * Test isNumber method with even number.
     */
    @Test
    public void whenSetEvenThenReturnTrue() {
        CheckInput checkInput = new CheckInput();
        assertThat(true, is(checkInput.isNumber(new ByteArrayInputStream("24".getBytes()))));
    }

    /**
     * Test isNumber method with odd number.
     */
    @Test
    public void whenSetOddThenReturnFalse() {
        CheckInput checkInput = new CheckInput();
        assertThat(false, is(checkInput.isNumber(new ByteArrayInputStream("33".getBytes()))));
    }

    /**
     * Test isNumber method with zero.
     */
    @Test
    public void whenSetZeroThenReturnFalse() {
        CheckInput checkInput = new CheckInput();
        assertThat(false, is(checkInput.isNumber(new ByteArrayInputStream("0".getBytes()))));
    }

    /**
     * Test isNumber method with char.
     */
    @Test
    public void whenSetCharThenReturnFalse() {
        CheckInput checkInput = new CheckInput();
        assertThat(false, is(checkInput.isNumber(new ByteArrayInputStream("a".getBytes()))));
    }
}
