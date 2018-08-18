package ru.sdroman.carstore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sdroman
 * @since 06.2018
 */
@Entity
@Table(name = "transmission")
public class Transmission {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    /**
     * Name.
     */
    @Column(name = "name")
    private String name;

    /**
     * Constructor.
     */
    public Transmission() {
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
     * Returns name.
     *
     * @return String name
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

        Transmission that = (Transmission) o;

        return id == that.id && (name != null ? name.equals(that.name) : that.name == null);
    }

    /**
     * HashCode.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
