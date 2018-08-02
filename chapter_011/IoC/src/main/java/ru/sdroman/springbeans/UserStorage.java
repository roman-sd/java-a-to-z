package ru.sdroman.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sdroman
 * @since 08.2018
 */
@Component
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
    @Autowired
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
