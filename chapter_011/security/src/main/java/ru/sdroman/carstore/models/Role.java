package ru.sdroman.carstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sdroman
 * @since 08.2018
 */
@Entity(name = "role")
public class Role {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name.
     */
    private String name;

    /**
     * Constructor.
     */
    public Role() {
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
}
