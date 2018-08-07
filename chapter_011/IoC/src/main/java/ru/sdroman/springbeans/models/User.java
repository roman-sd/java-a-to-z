package ru.sdroman.springbeans.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "user_id", nullable = false)
    private int id;

    /**
     * Name.
     */
    @Column(name = "name")
    private String name;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Returns id.
     *
     * @return int
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
     * Returns name.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Equals.
     *
     * @param o Object
     * @return true, if equal.
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

        return id == user.id;
    }

    /**
     * HashCode.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * ToStrung.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
