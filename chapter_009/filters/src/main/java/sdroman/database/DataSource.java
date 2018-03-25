package sdroman.database;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import sdroman.settings.Settings;

import java.sql.SQLException;

/**
 * @author sdroman
 * @since 03.2018
 */
public class DataSource {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(DataSource.class);

    /**
     * Instance.
     */
    private static DataSource instance;

    /**
     * Pool.
     */
    private BasicDataSource bDataSource;

    /**
     * Private constructor.
     */
    private DataSource() {
        Settings settings = new Settings("app.properties");
        bDataSource = new BasicDataSource();

        bDataSource.setDriverClassName(settings.getValue("driverClassName"));
        bDataSource.setUsername(settings.getValue("user"));
        bDataSource.setPassword(settings.getValue("pass"));
        bDataSource.setUrl(settings.getValue("url"));

        bDataSource.setMinIdle(0);
        bDataSource.setMaxIdle(20);
        bDataSource.setMaxOpenPreparedStatements(100);
    }

    /**
     * Returns instance.
     *
     * @return DataSource object
     */
    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public BasicDataSource getPool() {
        return bDataSource;
    }

    /**
     * Closes connection.
     */
    public void close() {
        if (bDataSource != null) {
            try {
                bDataSource.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
