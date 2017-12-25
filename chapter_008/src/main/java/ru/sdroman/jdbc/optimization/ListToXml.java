package ru.sdroman.jdbc.optimization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class ListToXML.
 *
 * @author sdroman
 * @since 12.2017
 */
public class ListToXml {

    /**
     * Creates xml file from list.
     *
     * @param list   list of entries
     * @param target path to xml file.
     */
    public void createXml(List<Entry> list, String target) {
        File file = null;
        try {
            Path path = Paths.get(target);
            if (Files.deleteIfExists(path)) {
                System.out.println("deleted existing file.");
            }
            file = Files.createFile(path).toFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Entries entries = new Entries();
        entries.setEntries(list);
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Entries.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(entries, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
