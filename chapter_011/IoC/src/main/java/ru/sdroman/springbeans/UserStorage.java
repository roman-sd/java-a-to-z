package ru.sdroman.springbeans;

/**
 * @author sdroman
 * @since 08.2018
 */
public class UserStorage {

    /**
     * Storage.
     */
    private final Storage storage;

    /**
     * Constructor.
     *
     * @param storage Storage
     */
    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    /**
     * Adds user to storage.
     *
     * @param user User
     */
    public void addUser(User user) {
        this.storage.add(user);
    }
}
