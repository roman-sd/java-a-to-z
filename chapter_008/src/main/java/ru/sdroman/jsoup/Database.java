package ru.sdroman.jsoup;

import org.apache.log4j.Logger;
import ru.sdroman.jdbc.optimization.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author sdroman
 * @since 02.2018
 */
public class Database {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(Database.class);

    /**
     * Settings.
     */
    private Settings settings = new Settings("jsoup.properties");

    /**
     * Connection to db.
     */
    private Connection con;

    /**
     * Connect to db.
     */
    public Database() {
        initDatabase();
    }

    /**
     * Checks database and connect.
     */
    private void initDatabase() {
        try {
            this.con = getConnection();
            if (!isTableExist()) {
                createTable();
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Returns connection.
     *
     * @return Connection
     * @throws SQLException exception
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                this.settings.getValue("url"),
                this.settings.getValue("user"),
                this.settings.getValue("pass")
        );
    }

    /**
     * Closes connection.
     */
    private void closeConnection() {
        if (this.con != null) {
            try {
                this.con.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Checks the table.
     *
     * @return true if exists
     */
    private boolean isTableExist() {
        boolean isExists = false;
        String query = "SELECT * FROM pg_tables WHERE tablename = 'vacancy'";
        try (Statement st = this.con.createStatement();
             ResultSet result = st.executeQuery(query)) {
            isExists = result.next();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return isExists;
    }

    /**
     * Creates the table.
     */
    private void createTable() {
        String query = "CREATE TABLE vacancy (id SERIAL PRIMARY KEY, author VARCHAR(50), "
                + "description VARCHAR(250) UNIQUE , create_date TIMESTAMP, link VARCHAR(500) UNIQUE)";
        try (Statement ps = this.con.createStatement()) {
            ps.executeUpdate(query);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Adds new vacancies to database.
     *
     * @param vacancyList List
     * @throws SQLException exception
     */
    public void updateVacancies(List<Vacancy> vacancyList) throws SQLException {
        String query = "INSERT INTO vacancy(author, description, create_date, link) VALUES (?, ?, ?, ?) "
                + "ON CONFLICT (description) DO NOTHING";

        try (PreparedStatement ps = this.con.prepareStatement(query)) {
            con.setAutoCommit(false);
            for (Vacancy vacancy : vacancyList) {
                ps.setString(1, vacancy.getAuthor());
                ps.setString(2, vacancy.getDescription());
                ps.setTimestamp(3, vacancy.getDate());
                ps.setString(4, vacancy.getLink());
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            try {
                con.rollback();
            } catch (SQLException exp) {
                LOG.error(exp.getMessage(), exp);
            }
        } finally {
            con.setAutoCommit(true);
            closeConnection();
        }
    }

    /**
     * Returns the date of the last vacancy.
     *
     * @return Timestamp
     */
    public Timestamp getDateLastVacancy() {
        String query = "SELECT create_date FROM vacancy ORDER BY create_date DESC LIMIT 1";
        Timestamp date = null;
        try (Statement st = this.con.createStatement();
             ResultSet result = st.executeQuery(query)) {
            if (result.next()) {
                date = result.getTimestamp("create_date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Removes vacancy.
     *
     * @param id int
     */
    public void dropVacancy(int id) {
        String query = "DELETE FROM vacancy WHERE id = ?";
        try (PreparedStatement st = this.con.prepareStatement(query)) {
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Removes vacancy table.
     */
    public void dropTable() {
        String query = "DROP TABLE IF EXISTS vacancy";
        try (Statement st = this.con.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
