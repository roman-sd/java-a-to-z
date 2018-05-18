package sdroman.models;

/**
 * @author sdroman
 * @since 04.2018
 */
public class City {

    /**
     * Id.
     */
    private String id;

    /**
     * Name.
     */
    private String name;

    /**
     * Constructs a new City object.
     * @param id String
     * @param name String
     */
    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns id.
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Returns name.
     * @return String
     */
    public String getName() {
        return name;
    }
}
