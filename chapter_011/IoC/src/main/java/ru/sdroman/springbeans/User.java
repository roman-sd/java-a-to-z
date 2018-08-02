package ru.sdroman.springbeans;

/**
 * @author sdroman
 * @since 08.2018
 */
public class User {

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
}
