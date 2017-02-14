package ru.sdroman.findFiles;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test ValidateKey class.
 *
 * @author sdroman
 * @version 0.1
 * @since 14.02.17
 */
public class ValidateKeyTest {

    /**
     * Test valid() method.
     */
    @Test
    public void whenKeysNotSevenThenReturnFalse() {
        String[] args = {"-d", "c://", "-n", "test.txt"};
        boolean actual = new ValidateKey(args).valid();
        assertThat(actual, is(false));
    }

    /**
     * Test valid() method.
     */
    @Test
    public void whenTheKeyIsHelpThenReturnFalse() {
        String[] args = {"-help"};
        boolean actual = new ValidateKey(args).valid();
        assertThat(actual, is(false));
    }

    /**
     * SetUp.
     *
     * @param args String[]
     * @return boolean
     */
    private boolean actual(String[] args) {
        return new ValidateKey(args).valid();
    }

    /**
     * Test valid() method.
     */
    @Test
    public void whenFirstKeysIsNotValidThenReturnFalse() {
        String[] args = {"-A", "c://", "-n", "test.txt", "-f", "-o", "log.log"};
        assertThat(actual(args), is(false));
    }

    /**
     * Test valid() method.
     */
    @Test
    public void whenSecondKeysIsNotValidThenReturnFalse() {
        String[] args = {"-d", "c://", "-A", "test.txt", "-f", "-o", "log.log"};
        assertThat(actual(args), is(false));
    }

    /**
     * Test valid() method.
     */
    @Test
    public void whenThirdKeysIsNotValidThenReturnFalse() {
        String[] args = {"-d", "c://", "-n", "test.txt", "-A", "-o", "log.log"};
        assertThat(actual(args), is(false));
    }

    /**
     * Test valid() method.
     */
    @Test
    public void whenFourthKeysIsNotValidThenReturnFalse() {
        String[] args = {"-d", "c://", "-n", "test.txt", "-f", "-A", "log.log"};
        assertThat(actual(args), is(false));
    }

    /**
     * Test valid() method.
     */
    @Test
    public void whenKeysIsValidateThenReturnTrue() {
        String[] args = {"-d", "c://", "-n", "test.txt", "-f", "-o", "log.log"};
        assertThat(actual(args), is(true));
    }
}
