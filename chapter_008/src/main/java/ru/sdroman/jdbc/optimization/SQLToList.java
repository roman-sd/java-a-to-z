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
     * N.
     */
    private final int n;

    /**
     * Name of table.
     */
    private final String tableName;

    /**
     * Connection to database.
     */
    private Connection connection = null;

    /**
     * Constructs a new SQLToList object.
     * @param tableName String
     * @param n int
     */
    public SQLToList(String tableName, int n) {
        this.n = n;
        this.tableName = tableName;
        connectToDataBase();
    }

    /**
     * Returns connection.
     * @return Connection
     * @throws SQLException exception
     */
    private Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:C:/sqlite/database.db";
        System.out.println("Connection to database..");
        return DriverManager.getConnection(url);
    }

    /**
     * Creates table.
     * @throws SQLException exception
     */
    private void createTable() throws SQLException {
        System.out.println("Create table..");
        Statement statement = this.connection.createStatement();
        statement.execute(CREATE_QUERY.replace("%tableName", this.tableName));
        statement.close();
    }

    /**
     * Fills the table.
     * @throws SQLException exception
     */
    private void initTable() throws SQLException {
        this.connection.setAutoCommit(false);
        System.out.println("Fills the table..");
        String query = INIT_QUERY.replace("%tableName", this.tableName);
        PreparedStatement statement = this.connection.prepareStatement(query);
        for (int i = 1; i <= this.n; i++) {
            statement.setInt(1, i);
            statement.addBatch();
        }
        statement.executeBatch();
        statement.close();
        this.connection.setAutoCommit(true);
    }

    /**
     * Removes the table.
     * @throws SQLException exception
     */
    private void dropTable() throws SQLException {
        System.out.println("Removes the table..");
        Statement statement = this.connection.createStatement();
        statement.execute(DROP_QUERY.replace("%tableName", this.tableName));
        statement.close();
    }

    /**
     * Closes connection.
     */
    private void closeConnection() {
        System.out.println("Close connection.");
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        try {
            this.connection = getConnection();
            ResultSet resultSet = this.connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                entry = new Entry();
                entry.setField(resultSet.getInt("field"));
                resultList.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return resultList;
    }

    /**
     * Main.
     */
    private void connectToDataBase() {
        try {
            this.connection = getConnection();
            dropTable();
            createTable();
            initTable();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
