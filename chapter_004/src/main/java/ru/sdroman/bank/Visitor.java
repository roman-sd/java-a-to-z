package ru.sdroman.bank;

import java.time.LocalTime;

/**
 * Class Visitor.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class Visitor {

    /**
     * in.
     */
    private LocalTime start;

    /**
     * out.
     */
    private LocalTime finish;

    /**
     * Constructs a new Visitor object.
     *
     * @param start  String
     * @param finish String
     */
    public Visitor(String start, String finish) {
        DateParam validate = new DateParam();
        this.start = validate.stringToLocalTime(start);
        this.finish = validate.stringToLocalTime(finish);
    }

    /**
     * Gets start time.
     *
     * @return LocalTime
     */
    public LocalTime getStart() {
        return this.start;
    }

    /**
     * Gets finish time.
     *
     * @return LocalTime
     */
    public LocalTime getFinish() {
        return this.finish;
    }
}
