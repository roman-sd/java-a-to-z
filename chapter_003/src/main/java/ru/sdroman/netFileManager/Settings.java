package ru.sdroman.netFileManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class Settings.
 */
public class Settings {

    /**
     * properties.
     */
    private final Properties prs = new Properties();

    /**
     * port.
     */
    private int port;

    /**
     * ip address.
     */
    private String address;

    /**
     * home path.
     */
    private String homePath;

    /**
     * download path.
     */
    private String downloadPath;

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
     * loads properties.
     *
     * @param fileName String
     * @throws IOException exception
     */
    private void loadProperties(String fileName) throws IOException {
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream(fileName)) {
            this.prs.load(io);
        }
        setPort(Integer.valueOf(this.prs.getProperty("port")));
        setAddress(this.prs.getProperty("ipAddress"));
        setHomePath(this.prs.getProperty("homePath"));
        setDownloadPath(this.prs.getProperty("downloadPath"));
    }

    /**
     * Gets ip address.
     *
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets ip address.
     *
     * @param address String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets port.
     *
     * @return int
     */
    public int getPort() {
        return this.port;
    }

    /**
     * Sets port.
     *
     * @param port int
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Gets home path.
     *
     * @return String
     */
    public String getHomePath() {
        return this.homePath;
    }

    /**
     * Sets home path.
     *
     * @param homePath String
     */
    public void setHomePath(String homePath) {
        this.homePath = homePath;
    }

    /**
     * Gets downloads path.
     *
     * @return String
     */
    public String getDownloadPath() {
        return this.downloadPath;
    }

    /**
     * Sets download path.
     *
     * @param downloadPath String
     */
    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }
}
