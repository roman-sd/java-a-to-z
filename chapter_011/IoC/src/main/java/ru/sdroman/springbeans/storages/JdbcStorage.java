package ru.sdroman.springbeans.storages;

import ru.sdroman.springbeans.models.User;
import ru.sdroman.springbeans.utils.Repository;

import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */

public class JdbcStorage extends Repository implements Storage {

    /**
     * Adds user.
     *
     * @param user User
     */
    @Override
    public int add(User user) {
        return (int) super.execute(session -> {
            return session.save(user);
        });
    }

    /**
     * Updates user.
     *
     * @param user User
     */
    @Override
    public void updateUser(User user) {
        super.execute(session -> {
            session.saveOrUpdate(user);
        });
    }

    /**
     * Removes user.
     *
     * @param user User
     */
    @Override
    public void deleteUser(User user) {
        super.execute(session -> {
            session.delete(user);
        });
    }

    /**
     * Returns user by id.
     *
     * @param userId int
     * @return User
     */
    @Override
    public User getUser(int userId) {
        return (User) super.execute(session -> {
            return session.createQuery("from User where id=:id")
                    .setParameter("id", userId)
                    .uniqueResult();
        });
    }

    /**
     * Returns all users.
     *
     * @return List<User>
     */
    @Override
    public List<User> getUsers() {
        return super.execute(session -> (List<User>) session.createQuery("from User").list());
    }
}
