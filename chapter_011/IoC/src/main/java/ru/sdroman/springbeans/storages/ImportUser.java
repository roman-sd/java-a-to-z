package ru.sdroman.springbeans.storages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.sdroman.springbeans.models.User;

import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
@Component
public class ImportUser {

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
    public ImportUser(Storage storage) {
        this.storage = storage;
    }

    /**
     * Adds user to storage.
     *
     * @param user User
     * @return int userId
     */
    public int addUser(User user) {
        return this.storage.add(user);
    }

    /**
     * Delete user from storage.
     *
     * @param user User
     */
    public void deleteUser(User user) {
        this.storage.deleteUser(user);
    }

    /**
     * Update user.
     *
     * @param user User
     */
    public void updateUser(User user) {
        this.storage.updateUser(user);
    }

    /**
     * Returns user by id.
     *
     * @param id int
     * @return User
     */
    public User getUser(int id) {
        return this.storage.getUser(id);
    }

    /**
     * Returns user list.
     *
     * @return List<User>
     */
    public List<User> getUsers() {
        return this.storage.getUsers();
    }

    /**
     * Main.
     * @param args String
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Storage jdbcStorage = context.getBean(JdbcStorage.class);
        ImportUser importUser = new ImportUser(jdbcStorage);
        User user = new User();
        user.setName("admin");
        importUser.addUser(user);
    }
}
