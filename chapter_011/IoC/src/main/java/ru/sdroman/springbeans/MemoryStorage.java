package ru.sdroman.springbeans;

import org.apache.log4j.Logger;

/**
 * @author sdroman
 * @since 08.2018
 */
public class MemoryStorage implements Storage {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(MemoryStorage.class);

    /**
     * Adds user.
     *
     * @param user User
     */
    @Override
    public void add(User user) {
        System.out.println("Memory storage");
    }
}
