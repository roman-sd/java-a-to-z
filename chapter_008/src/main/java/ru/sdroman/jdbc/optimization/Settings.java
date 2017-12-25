package ru.sdroman.jdbc.optimization;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sdroman
 * @since 12.2017
 */
public class Settings {

    /**
     * Properties.
     */
    private final Properties properties = new Properties();

    /**
     * Constructs a new Setting object.
     *
     * @param fileName String
     */
    public Settings(String fileName) {
        loadProperties(fileName);
    }

    /**
     * Loads properties.
     *
     * @param fileName String
     */
    private void loadProperties(String fileName) {
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream(fileName)) {
            this.properties.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns value by key.
     *
     * @param key String
     * @return String
     */
    public String getValue(final String key) {
        return this.properties.getProperty(key);
    }
}
