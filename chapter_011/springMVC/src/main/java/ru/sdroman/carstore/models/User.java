package ru.sdroman.carstore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author sdroman
 * @since 08.2018
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    /**
     * Login.
     */
    @Column(name = "login")
    private String login;

    /**
     * Password.
     */
    @Column(name = "password")
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

    /**
     * Equals.
     *
     * @param o Object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (id != user.id) {
            return false;
        }
        return (login != null ? login.equals(user.login) : user.login == null) && (password != null ? password.equals(user.password) : user.password == null);
    }

    /**
     * HachCode.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
