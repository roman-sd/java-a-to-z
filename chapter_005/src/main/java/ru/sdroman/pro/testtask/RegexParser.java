package ru.sdroman.pro.testtask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class RegexParser.
 * @author sdroman
 * @since 06.2017
 */
public class RegexParser {

    /**
     * Pattern for addOrder method.
     */
    private Pattern pattern = Pattern.compile("\"(.*?)\"(.*?)\"(.*?)\"(.*?)\"(.*?)\"(.*?)\"(.*?)\"(.*?)\"(.*?)\"");

    /**
     * Pattern for deleteOrder method.
     */
    private Pattern patternDel = Pattern.compile("\"(.*?)\"(.*?)\"(.*?)\"");

    /**
     * Map.
     */
    private Map<Integer, Order> map = new HashMap<>();

    /**
     * Matcher.
     */
    private Matcher m;

    /**
     * Adds order to map.
     * @param book String
     * @param operation String
     * @param price String
     * @param vol String
     * @param id String
     */
    private void addOrder(String book, String operation, String price, String vol, String id) {
        Integer orderId = Integer.valueOf(id);
        Order order = new Order(book,
                operation,
                Double.valueOf(price.trim()),
                Integer.valueOf(vol),
                orderId);
        this.map.put(orderId, order);
    }

    /**
     * Removes the order from map.
     * @param id String
     */
    private void deleteOrder(String id) {
        this.map.remove(Integer.valueOf(id));
    }

    /**
     * Parser.
     * @param file String
     * @return Map
     */
    public Map<Integer, Order> parse(final String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("AddOrder")) {
                    m = pattern.matcher(line);
                    if (m.find()) {
                        this.addOrder(m.group(1),
                                m.group(3),
                                m.group(5),
                                m.group(7),
                                m.group(9));
                    }
                } else {
                    if (line.contains("DeleteOrder")) {
                        m = patternDel.matcher(line);
                        if (m.find()) {
                            this.deleteOrder(m.group(3));
                        }
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
     * @return Map
     */
    public Map<Integer, Order> getMap() {
        return map;
    }
}
