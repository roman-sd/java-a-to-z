package ru.sdroman.jdbc.optimization;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * ParseXML.
 *
 * @author sdroman
 * @since 12.2017
 */
public class ParseXML {

    /**
     * Returns the average from xml file.
     *
     * @param path xml file
     * @param n    number
     * @return int average
     */
    public int average(String path, int n) {
        String current;
        int sum = 0;
        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader reader = factory.createXMLStreamReader(path, new FileInputStream(path));

            while (reader.hasNext()) {
                reader.next();
                if (reader.isStartElement()) {
                    if (reader.getLocalName().equals("entry")) {
                        current = reader.getAttributeValue(null, "field");
                        sum += Integer.parseInt(current);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return sum / n;
    }
}
