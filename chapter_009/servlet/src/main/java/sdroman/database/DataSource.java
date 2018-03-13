package sdroman.database;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import sdroman.settings.Settings;

import java.sql.Connection;
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
    private BasicDataSource ds;

    /**
     * Private constructor.
     */
    private DataSource() {
        Settings settings = new Settings("app.properties");
        ds = new BasicDataSource();

        ds.setDriverClassName(settings.getValue("driverClassName"));
        ds.setUsername(settings.getValue("user"));
        ds.setPassword(settings.getValue("pass"));
        ds.setUrl(settings.getValue("url"));

        ds.setMinIdle(0);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(100);
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

    /**
     * Returns connection.
     *
     * @return Connection
     * @throws SQLException exception
     */
    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    /**
     * Closes connection.
     */
    public void close() {
        if (ds != null) {
            try {
                ds.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
