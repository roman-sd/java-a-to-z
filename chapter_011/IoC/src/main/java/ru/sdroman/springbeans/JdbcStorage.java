package ru.sdroman.springbeans;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author sdroman
 * @since 08.2018
 */
@Component
public class JdbcStorage implements Storage {

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
        System.out.println("Jdbc storage.");
    }
}
