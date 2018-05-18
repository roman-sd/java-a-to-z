package sdroman.database;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import sdroman.models.City;
import sdroman.models.Country;
import sdroman.models.Role;
import sdroman.models.User;

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
     *
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
                     "SELECT u.name, u.login, u.password, u.email, u.create_date, r.id, r.name AS role, "
                             + "city.name AS city, c.name AS country "
                             + "FROM users u JOIN role r ON u.role_id = r.id "
                             + "JOIN city ON u.city_id = city.id JOIN country c ON city.country_id = c.id;")) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("create_date"),
                        Role.valueOf(resultSet.getString("role")),
                        resultSet.getString("country"),
                        resultSet.getString("city"));
                userList.add(user);
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return userList;
    }

    /**
     * Returns user by login.
     *
     * @param login String
     * @return User
     */
    public User getUserByLogin(String login) {
        User user = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "SELECT  u.name, u.login, u.password, u.email, u.create_date, "
                             + "r.name AS role, city.name AS city, c.name AS country "
                             + "FROM users u JOIN role r ON u.role_id = r.id "
                             + "JOIN city ON u.city_id = city.id "
                             + "JOIN country c ON city.country_id = c.id "
                             + "WHERE login = ?;")) {
            st.setString(1, login);
            try (ResultSet resultSet = st.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(
                            resultSet.getString("name"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            resultSet.getTimestamp("create_date"),
                            Role.valueOf(resultSet.getString("role")),
                            resultSet.getString("country"),
                            resultSet.getString("city"));
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
                     "INSERT INTO users (name, login, password, email, create_date, role_id, "
                             + "city_id) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setTimestamp(5, user.getCreateDate());
            ps.setInt(6, getRoleId(user.getRole()));
            ps.setInt(7, getCityId(user.getCity()));
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Returns city id.
     *
     * @param city String
     * @return int
     */
    private int getCityId(String city) {
        int cityId = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM city WHERE name = ?")) {
            ps.setString(1, city);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    cityId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return cityId;
    }

    /**
     * Returns country id.
     *
     * @param country String
     * @return int
     */
    private int getCountryId(String country) {
        int id = 0;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM country WHERE name = ?")) {
            ps.setString(1, country);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    id = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return id;
    }

    /**
     * Get role id.
     *
     * @param role Role
     * @return int
     */
    private int getRoleId(Role role) {
        int roleId = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT role.id FROM role WHERE name = ?")) {
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
                     "UPDATE users SET name = ?, password = ?, email = ?, role_id = ?, city_id = ? "
                             + "WHERE login = ?")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, getRoleId(user.getRole()));
            ps.setInt(5, getCityId(user.getCity()));
            ps.setString(6, user.getLogin());
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
     */
    public void removeUser(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE login = ?")) {
            ps.setString(1, user.getLogin());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Returns country list.
     *
     * @return List<Country>
     */
    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT c.id, c.name FROM country c;");
             ResultSet result = ps.executeQuery()) {
            while (result.next()) {
                countries.add(new Country(result.getString("id"), result.getString("name")));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return countries;
    }

    /**
     * Returns city list.
     *
     * @param country String
     * @return List<City>
     */
    public List<City> getCities(String country) {
        List<City> cities = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id, name FROM city WHERE country_id = ?;")) {
            ps.setInt(1, getCountryId(country));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cities.add(new City(rs.getString("id"), rs.getString("name")));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return cities;
    }
}
