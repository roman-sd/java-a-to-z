package ru.sdroman.nonblocking;

/**
 * @author sdroman
 * @since 08.2017
 */
public class Task {

    /**
     * Version.
     */
    private volatile long version = 0;

    /**
     * Name.
     */
    private String name;

    /**
     * Id.
     */
    private long id;

    /**
     * Constructs a new Task object.
     * @param name String
     * @param id long
     */
    public Task(String name, long id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Returns name.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns version.
     * @return long
     */
    public long getVersion() {
        return version;
    }

    /**
     * Returns id.
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * Version update.
     */
    public void updateVersion() {
        this.version++;
    }

    /**
     * Sets name.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
}
