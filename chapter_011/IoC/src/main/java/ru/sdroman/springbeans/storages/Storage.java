package ru.sdroman.springbeans.storages;

import ru.sdroman.springbeans.models.User;

import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
public interface Storage {

    /**
     * Adds user.
     *
     * @param user User
     * @return userId
     */
    int add(User user);

    /**
     * Updates user.
     *
     * @param user User
     */
    void updateUser(User user);

    /**
     * Removes user.
     *
     * @param user User
     */
    void deleteUser(User user);

    /**
     * Returns user by id.
     *
     * @param userId int
     * @return User
     */
    User getUser(int userId);

    /**
     * Returns all users.
     *
     * @return List<User>
     */
    List<User> getUsers();
}
