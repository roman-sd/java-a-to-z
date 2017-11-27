package ru.sdroman.cash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author sdroman
 * @since 11.2017
 */
public class SoftCash extends AbstractCash<String, String> {

    /**
     * Path.
     */
    private final String path;

    /**
     * Constructs a new SoftCash object.
     * @param path String
     */
    public SoftCash(String path) {
        this.path = path;
    }

    /**
     * Load data from disk.
     * @param key K
     * @return String
     */
    @Override
    String getData(String key) {
        final String ls = System.getProperty("line.separator");
        StringBuilder builder = new StringBuilder();
        File file = new File(path, key);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine()).append(ls);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
