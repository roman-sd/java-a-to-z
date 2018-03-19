package sdroman.database;

import org.apache.log4j.Logger;
import sdroman.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sdroman
 * @since 03.2018
 */
public class UserStore {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(UserStore.class);

    /**
     * Returns users list.
     *
     * @return List
     */
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = DataSource.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users ORDER BY login")) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("createDate")
                );
                userList.add(user);
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
     */
    public void addUser(User user) {
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO users (name, login, email, createdate) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setTimestamp(4, user.getCreateDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Updates user by login.
     *
     * @param user Users
     * @return number of rows affected by an update
     */
    public int editUser(User user) {
        int updateRow = 0;
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "UPDATE users SET name = ?, email = ? WHERE login = ?")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getLogin());
            updateRow = ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return updateRow;
    }

    /**
     * Removes user by login.
     *
     * @param user User
     * @return true if successful
     */
    public boolean removeUser(User user) {
        boolean done = false;
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE login = ?")) {
            ps.setString(1, user.getLogin());
            ps.executeUpdate();
            done = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return done;
    }
}
