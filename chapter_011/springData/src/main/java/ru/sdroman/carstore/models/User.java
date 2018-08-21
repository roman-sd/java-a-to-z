package ru.sdroman.carstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author sdroman
 * @since 08.2018
 */
@Entity(name = "users")
public class User {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Login.
     */
    private String login;

    /**
     * Password.
     */
    private String password;

    /**
     * Orders.
     */
    @OneToMany
    private Set<Order> orders;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Returns id.
     *
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns login.
     *
     * @return String login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login String
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns password.
     *
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns orders.
     *
     * @return Set
     */
    public Set<Order> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders Set
     */
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}
