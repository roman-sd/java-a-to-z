package ru.sdroman.pro.testtask;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class Book.
 *
 * @author sdroman
 * @since 05.2017
 */
public class Book {

    /**
     * Bid.
     */
    private Map<Double, Order> bid = new TreeMap<>(Comparator.reverseOrder());

    /**
     * Ask.
     */
    private Map<Double, Order> ask = new TreeMap<>(Comparator.naturalOrder());

    /**
     * Returns bids.
     *
     * @return Map
     */
    public Map<Double, Order> getBid() {
        return bid;
    }

    /**
     * Returns asks.
     *
     * @return Map
     */
    public Map<Double, Order> getAsk() {
        return ask;
    }
}
