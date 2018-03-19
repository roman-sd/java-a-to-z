package sdroman.database;

import org.apache.log4j.Logger;
import org.postgresql.Driver;
import sdroman.model.User;
import sdroman.settings.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sdroman
 * @since 03.2018
 */
public final class UserStore {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(UserStore.class);

    /**
     * Instance.
     */
    private static volatile UserStore instance = null;

    /**
     * Connection.
     */
    private Connection connection;

    /**
     * Private constructor.
     */
    private UserStore() {
        Settings settings = new Settings("app.properties");
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    settings.getValue("url"),
                    settings.getValue("user"),
                    settings.getValue("pass"));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Returns instance.
     *
     * @return UserStore
     */
    public static UserStore getInstance() {
        if (instance == null) {
            synchronized (UserStore.class) {
                if (instance == null) {
                    instance = new UserStore();
                }
            }
        }
        return instance;
    }

    /**
     * Returns connection.
     *
     * @return Connection
     */
    private Connection getConnection() {
        return this.connection;
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