package ru.sdroman.pro.testtask;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class StAXParser.
 *
 * @author sdroman
 * @since 05.2017
 */
public class StAXParser {

    /**
     * Map.
     */
    private Map<Integer, Order> map = new HashMap<>();


    /**
     * Adds order to map.
     *
     * @param reader XMLStreamReader.
     */
    private void addOrder(final XMLStreamReader reader) {
        Order order = new Order(reader.getAttributeValue(null, "book"),
                reader.getAttributeValue(null, "operation"),
                Double.valueOf(reader.getAttributeValue(null, "price")),
                Integer.valueOf(reader.getAttributeValue(null, "volume")),
                Integer.valueOf(reader.getAttributeValue(null, "orderId")));

        this.map.put(Integer.valueOf(reader.getAttributeValue(null, "orderId")),
                order);
    }

    /**
     * Removes the order from the map.
     *
     * @param reader XMLStreamReader
     */
    private void deleteOrder(final XMLStreamReader reader) {
        this.map.remove(Integer.valueOf(reader.getAttributeValue(null, "orderId")));
    }

    /**
     * Parser.
     *
     * @param file String
     * @return Map
     */
    public Map<Integer, Order> parse(final String file) {
        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader r = factory.createXMLStreamReader(file, new FileInputStream(file));

            while (r.hasNext()) {
                r.next();
                if (r.isStartElement()) {
                    if ("AddOrder".equals(r.getLocalName())) {
                        this.addOrder(r);
                    } else {
                        if ("DeleteOrder".equals(r.getLocalName())) {
                            this.deleteOrder(r);
                        }
                    }
                }
            }
        } catch (XMLStreamException | IOException ex) {
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
