package ru.sdroman.bank;

import java.time.LocalTime;

/**
 * Class DateParam.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class DateParam {

    /**
     * Return date in LocalTime.
     *
     * @param date String
     * @return LocalTime
     */
    public LocalTime stringToLocalTime(String date) {
        return LocalTime.parse(date);
    }
}
