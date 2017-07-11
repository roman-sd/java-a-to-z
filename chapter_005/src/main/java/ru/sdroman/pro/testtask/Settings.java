package ru.sdroman.pro.testtask;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sdroman
 * @since 05.2017
 */
public class Settings {

    /**
     * Properties.
     */
    private final Properties prs = new Properties();

    /**
     * Constructs new Settings object.
     *
     * @param fileName String
     * @throws IOException exception
     */
    Settings(String fileName) throws IOException {
        loadProperties(fileName);
    }

    /**
     * Loads properties.
     *
     * @param fileName String
     * @throws IOException exception
     */
    private void loadProperties(String fileName) throws IOException {
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream(fileName)) {
            this.prs.load(io);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gets value by key.
     * @param key String
     * @return String
     */
    public String getValue(final String key) {
        return this.prs.getProperty(key);
    }
}
