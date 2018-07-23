package ru.sdroman.carsales.repository;

import ru.sdroman.carsales.models.User;

/**
 * @author sdroman
 * @since 06.2018
 */
public class UserRepository extends Repository {

    /**
     * Adds user to db.
     *
     * @param user User
     */
    public void addUser(User user) {
        super.execute(session -> session.save(user));
    }

    /**
     * Returns user by login.
     *
     * @param login String
     * @return User
     */
    public User getUserByLogin(String login) {
        return (User) super.execute(session ->
                session.createQuery("from ru.sdroman.carsales.models.User where login=:login")
                        .setParameter("login", login)
                        .uniqueResult());
    }
}
