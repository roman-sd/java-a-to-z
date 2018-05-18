package sdroman.models;

/**
 * @author sdroman
 * @since 04.2018
 */
public class Country {

    /**
     * Id.
     */
    private String id;

    /**
     * Name.
     */
    private String name;

    /**
     * Constructs a new Country object.
     *
     * @param id   String
     * @param name String
     */
    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns id.
     *
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Returns name.
     *
     * @return String
     */
    public String getName() {
        return name;
    }
}
