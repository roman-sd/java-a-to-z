package sdroman.database;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import sdroman.model.Role;
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
     * Database.
     */
    private BasicDataSource dataSource;

    /**
     * Constructs UserStore object.
     * @param dataSource BasicDataSource
     */
    public UserStore(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Returns users list.
     *
     * @return List
     */
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT u.name, u.login, u.password, u.email, u.create_date, r.id, r.name as role "
                             + "FROM users u JOIN role r ON u.role_id = r.id")) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("create_date"),
                        Role.valueOf(resultSet.getString("role")));
                userList.add(user);
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return userList;
    }

    /**
     * Returns user by login.
     * @param login String
     * @return User
     */
    public User getUserByLogin(String login) {
        User user = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "SELECT  u.*, r.id, r.name as role " +
                             "FROM users u JOIN role r ON u.role_id = r.id WHERE login = ?")) {
            st.setString(1, login);
            try (ResultSet resultSet = st.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(
                            resultSet.getString("name"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            resultSet.getTimestamp("create_date"),
                            Role.valueOf(resultSet.getString("role")));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return user;
    }

    /**
     * Inserts users to database.
     *
     * @param user User
     */
    public void addUser(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO users (name, login, password, email, create_date, role_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setTimestamp(5, user.getCreateDate());
            ps.setInt(6, getRoleId(user.getRole()));
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Get role id.
     * @param role Role
     * @return int
     */
    public int getRoleId(Role role) {
        int roleId = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM role WHERE name = ?")) {
            ps.setString(1, role.name());
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    roleId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return roleId;
    }

    /**
     * Updates user by login.
     *
     * @param user Users
     * @return number of rows affected by an update
     */
    public int editUser(User user) {
        int updateRow = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "UPDATE users SET name = ?, password = ?, email = ?, role_id = ? WHERE login = ?")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, getRoleId(user.getRole()));
            ps.setString(5, user.getLogin());
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
        try (Connection connection = dataSource.getConnection();
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
