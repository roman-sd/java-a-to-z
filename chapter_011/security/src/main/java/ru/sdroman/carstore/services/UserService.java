package ru.sdroman.carstore.services;

import ru.sdroman.carstore.models.User;

import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
public interface UserService {

    /**
     * Returns user by id.
     *
     * @param id int
     * @return User
     */
    User getUser(int id);

    /**
     * Create or update user.
     *
     * @param user User without id
     * @return user with id
     */
    User saveUser(User user);

    /**
     * Returns all users.
     *
     * @return List
     */
    List<User> getUsers();

    /**
     * Returns user by username.
     *
     * @param name String
     * @return User
     */
    User getUserByName(String name);
}

