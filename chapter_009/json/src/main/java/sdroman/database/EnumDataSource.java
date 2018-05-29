package sdroman.database;

import org.apache.commons.dbcp.BasicDataSource;
import sdroman.settings.Settings;

import java.sql.Connection;

/**
 * @author sdroman
 * @since 05.2018
 */
public enum EnumDataSource {
    INSTANCE;


    /**
     * Pool.
     */
    private BasicDataSource bDataSource;

    /**
     * Private constructor.
     */
    private EnumDataSource() {
        Settings settings = new Settings("app.properties");
        this.bDataSource = new BasicDataSource();

        bDataSource.setDriverClassName(settings.getValue("driverClassName"));
        bDataSource.setUsername(settings.getValue("user"));
        bDataSource.setPassword(settings.getValue("pass"));
        bDataSource.setUrl(settings.getValue("url"));

        bDataSource.setMinIdle(0);
        bDataSource.setMaxIdle(20);
        bDataSource.setMaxOpenPreparedStatements(100);
    }

    /**
     * Returns connection pool.
     *
     * @return BasicDataSource
     */
    public BasicDataSource getPool() {
        return bDataSource;
    }
}
