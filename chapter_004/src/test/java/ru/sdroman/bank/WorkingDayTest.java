package ru.sdroman.bank;

import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test WorkingDay class.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class WorkingDayTest {

    /**
     * Test maxVisitorPeriod method.
     */
    @Test
    public void whenSetFiveVisitorThenReturnMaxVisitors() {
        final int hoursStart = 10;
        final int minutesStart = 25;
        final int hoursFinish = 10;
        final int minutesFinish = 30;
        final int numberVisitors = 5;
        WorkingDay wd = new WorkingDay(numberVisitors);
        List<Visitor> list = new ArrayList<>();
        list.add(new Visitor("09:15", "10:30"));
        list.add(new Visitor("09:30", "10:50"));
        list.add(new Visitor("10:25", "11:50"));
        list.add(new Visitor("10:05", "11:30"));
        list.add(new Visitor("11:00", "12:10"));
        String actual = wd.maxVisitorPeriod(list);
        String expected = LocalTime.of(hoursStart, minutesStart).toString()
                + " - " + LocalTime.of(hoursFinish, minutesFinish);
        assertThat(actual, is(expected));
    }
}
