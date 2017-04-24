package ru.sdroman.pro.generic;

/**
 * Class Base.
 *
 * @author sdroman
 * @since 04.17
 */
public abstract class Base {

    /**
     * ID.
     */
    private String id;

    /**
     * Returns id.
     *
     * @return String
     */
    public String getId() {

        return id;
    }

    /**
     * Sets id.
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }
}
