package ru.sdroman.springbeans.storages;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.sdroman.springbeans.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
@Component
public class MemoryStorage implements Storage {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(MemoryStorage.class);

    /**
     * Inner storage.
     */
    private List<User> memStorage = new ArrayList<>();

    /**
     * Id from memStorage.
     */
    private int id;

    /**
     * Adds user.
     *
     * @param user User
     * @return int userId
     */
    @Override
    public int add(User user) {
        this.memStorage.add(user);
        user.setId(++id);
        return user.getId();
    }

    /**
     * Updates user.
     *
     * @param user User
     */
    @Override
    public void updateUser(User user) {
        if (this.isExist(user)) {
            int index = memStorage.indexOf(user);
            memStorage.set(index, user);
        }
    }

    /**
     * Removes user.
     *
     * @param user User
     */
    @Override
    public void deleteUser(User user) {
        if (this.isExist(user)) {
            this.memStorage.remove(user);
        }
    }

    /**
     * Returns user by id.
     *
     * @param userId int
     * @return User
     */
    @Override
    public User getUser(int userId) {
        User user = new User();
        user.setId(this.id);
        if (this.isExist(user)) {
            int index = this.memStorage.indexOf(user);
            user = this.memStorage.get(index);
        } else {
            user = null;
        }
        return user;
    }

    /**
     * Returns all users.
     *
     * @return List<User>
     */
    @Override
    public List<User> getUsers() {
        return this.memStorage;
    }

    /**
     * Returns true if user exists in storage.
     *
     * @param user User
     * @return true if exist
     */
    private boolean isExist(User user) {
        return this.memStorage.contains(user);
    }
}
