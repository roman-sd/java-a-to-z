package ru.sdroman.pro.testtask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Splitter.
 *
 * @author sdroman
 * @since 06.2017
 */
public class Splitter {

    /**
     * Number of attributes.
     */
    private static final int ATR_NUM = 5;
    /**
     * Attributes.
     */
    private String[] attributes = new String[ATR_NUM];

    /**
     * Map.
     */
    private Map<Integer, Order> map = new HashMap<>();

    /**
     * Returns true if num is even.
     *
     * @param num int
     * @return boolean
     */
    private boolean isEven(int num) {
        return num % 2 != 0;
    }

    /**
     * Adds order to map.
     *
     * @param line String
     */
    private void addOrder(String line) {
        split(line);
        final int idNum = 4;
        int count = 0;
        Order order = new Order(attributes[count++],
                attributes[count++],
                Double.valueOf(attributes[count++]),
                Integer.valueOf(attributes[count++]),
                Integer.valueOf(attributes[count]));
        this.map.put(Integer.valueOf(attributes[idNum]), order);
    }

    /**
     * Splits up the string.
     *
     * @param line String
     */
    private void split(String line) {
        int count = 0;
        int i = 0;
        for (String chunk : line.split("\"")) {
            if (isEven(count)) {
                attributes[i++] = chunk;
            }
            count++;
        }
    }

    /**
     * Removes the order from the map.
     *
     * @param line String
     */
    private void deleteOrder(String line) {
        split(line);
        this.map.remove(Integer.valueOf(attributes[1]));
    }

    /**
     * Parser.
     *
     * @param file String
     * @return Map
     */
    public Map<Integer, Order> parse(final String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("AddOrder")) {
                    addOrder(line);
                } else {
                    if (line.contains("DeleteOrder")) {
                        deleteOrder(line);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return map;
    }

    /**
     * Returns map.
     *
     * @return Map
     */
    public Map<Integer, Order> getMap() {
        return map;
    }
}
