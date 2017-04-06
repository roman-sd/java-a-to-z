package ru.sdroman.bank;

import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test DateParam class.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class DateParamTest {

    /**
     * Test stringToLocalTime method.
     */
    @Test
    public void whenSetStringThenReturnLocalDate() {
        final int hours = 14;
        final int minutes = 25;
        DateParam dateParam = new DateParam();
        String testTime = "14:25";
        LocalTime actual = dateParam.stringToLocalTime(testTime);
        LocalTime expected = LocalTime.of(hours, minutes);
        assertThat(actual, is(expected));
    }
}
