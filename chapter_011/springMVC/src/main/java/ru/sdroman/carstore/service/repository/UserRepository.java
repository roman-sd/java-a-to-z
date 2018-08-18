package ru.sdroman.carstore.service.repository;

import ru.sdroman.carstore.models.User;
import ru.sdroman.carstore.service.Repository;

/**
 * @author sdroman
 * @since 06.2018
 */
public class UserRepository extends Repository {

    /**
     * Adds user to db.
     *
     * @param user User
     * @return photoId
     */
    public int addUser(User user) {
        return super.execute(session -> (int) session.save(user));
    }

    /**
     * Returns user by login.
     *
     * @param login String
     * @return User
     */
    public User getUserByLogin(String login) {
        return super.execute(session -> (User) session
                .createQuery("from User where login=:login")
                .setParameter("login", login)
                .uniqueResult());
    }
}
