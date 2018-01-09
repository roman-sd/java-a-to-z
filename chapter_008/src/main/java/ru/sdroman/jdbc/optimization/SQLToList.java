package ru.sdroman.jdbc.optimization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sdroman
 * @since 12.2017
 */
public class SQLToList {

    /**
     * Drop table.
     */
    private static final String DROP_QUERY = "DROP TABLE IF EXISTS %tableName";

    /**
     * Create table.
     */
    private static final String CREATE_QUERY = "CREATE TABLE %tableName (field INTEGER)";

    /**
     * Insert into table.
     */
    private static final String INIT_QUERY = "INSERT INTO %tableName VALUES (?)";

    /**
     * Select from table.
     */
    private static final String SELECT_QUERY = "SELECT * FROM %tableName";

    /**
     * Url.
     */
    private final String url;

    /**
     * N.
     */
    private final int n;

    /**
     * Name of table.
     */
    private final String tableName;

    /**
     * Constructs a new SQLToList object.
     * @param tableName String
     * @param n int
     */
    public SQLToList(String tableName, int n, String url) {
        this.n = n;
        this.tableName = tableName;
        this.url = url;
        connectToDataBase();
    }

    /**
     * Creates table.
     */
    private void createTable() {
        System.out.println("Create table..");
        try (Connection con = DriverManager.getConnection(url);
             Statement statement = con.createStatement()) {
            statement.execute(CREATE_QUERY.replace("%tableName", this.tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fills the table.
     */
    private void initTable() {
        System.out.println("Fills the table..");
        String query = INIT_QUERY.replace("%tableName", this.tableName);

        try (Connection con = DriverManager.getConnection(url)) {
            con.setAutoCommit(false);

            try (PreparedStatement statement = con.prepareStatement(query)) {
                for (int i = 1; i <= this.n; i++) {
                    statement.setInt(1, i);
                    statement.addBatch();
                }
                statement.executeBatch();
            }
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes the table.
     */
    private void dropTable() {
        System.out.println("Removes the table..");
        try (Connection con = DriverManager.getConnection(url);
             Statement statement = con.createStatement()) {
            statement.execute(DROP_QUERY.replace("%tableName", this.tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * From table to list.
     * @return List
     */
    public List<Entry> sqlToList() {
        String query = SELECT_QUERY.replace("%tableName", this.tableName);
        Entry entry;
        List<Entry> resultList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url)) {
            con.setAutoCommit(false);

            try (ResultSet resultSet = con.createStatement().executeQuery(query)) {
                while (resultSet.next()) {
                    entry = new Entry();
                    entry.setField(resultSet.getInt("field"));
                    resultList.add(entry);
                }
            }
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Main.
     */
    private void connectToDataBase() {
        dropTable();
        createTable();
        initTable();
    }
}
