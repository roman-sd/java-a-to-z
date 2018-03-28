package sdroman.database;

import org.apache.log4j.Logger;
import sdroman.model.User;
import sdroman.settings.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sdroman
 * @since 03.2018
 */
public enum UserStorage {
    INSTANCE;

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(UserStorage.class);

    /**
     * Returns connection.
     *
     * @return Connection
     */
    private Connection getConnection() {
        Settings settings = new Settings("app.properties");
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    settings.getValue("url"),
                    settings.getValue("user"),
                    settings.getValue("pass"));
        } catch (SQLException | ClassNotFoundException e) {
            LOG.error(e.getMessage(), e);
        }
        return connection;
    }

    /**
     * Returns users list.
     *
     * @return List
     */
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Statement statement = getConnection().createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    User user = new User(
                            resultSet.getString("name"),
                            resultSet.getString("login"),
                            resultSet.getString("email"),
                            resultSet.getTimestamp("createDate")
                    );
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return userList;
    }

    /**
     * Insert users to database.
     *
     * @param user User
     * @return true if successful
     */
    public boolean addUser(User user) {
        boolean done = false;
        String query = "INSERT INTO users (name, login, email, createdate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            done = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return done;
    }

    /**
     * Updates user by login.
     *
     * @param user Users
     * @return number of rows affected by an update
     */
    public int editUser(User user) {
        int update = 0;
        String query = "UPDATE users SET name = ?, login = ?, email = ? WHERE login = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getLogin());
            update = ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return update;
    }

    /**
     * Removes user by login.
     *
     * @param user User
     * @return true if successful
     */
    public boolean removeUser(User user) {
        boolean done = false;
        String query = "DELETE FROM users WHERE login = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setString(1, user.getLogin());
            ps.executeUpdate();
            done = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return done;
    }
}
