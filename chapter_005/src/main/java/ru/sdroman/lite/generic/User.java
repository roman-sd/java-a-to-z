package ru.sdroman.lite.generic;

/**
 * Class User.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class User {

    /**
     * User's name.
     */
    private String name;

    /**
     * User's id.
     */
    private int id;

    /**
     * User's city.
     */
    private String city;

    /**
     * Constructs a new User object.
     *
     * @param name String
     * @param id   int
     * @param city String
     */
    public User(String name, int id, String city) {
        this.name = name;
        this.id = id;
        this.city = city;
    }

    /**
     * Gets name.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets id.
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Gets city.
     *
     * @return String
     */
    public String getCity() {
        return city;
    }
}
