package ru.sdroman.carsales.models;

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
@Table(name = "drivetype")
public class DriveType {

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
    public DriveType() {
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
}
