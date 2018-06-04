package ru.sdroman.models;

/**
 * @author sdroman
 * @since 06.2018
 */
public class Model {

    /**
     * Id.
     */
    private int id;

    /**
     * Name.
     */
    private String name;

    /**
     * Constructor.
     */
    public Model() {
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
