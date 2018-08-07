package ru.sdroman.springbeans.storages;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sdroman.springbeans.models.User;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * @author sdroman
 * @since 08.2018
 */
public class MemoryStorageTest {

    /**
     * ImportUser.
     */
    private ImportUser importUser;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        importUser = new ImportUser(context.getBean(MemoryStorage.class));
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddUserShouldAssignId() {
        User user = new User();
        user.setName("admin");
        importUser.addUser(user);
        assertNotNull(user.getId());
    }

    /**
     * Test update method.
     */
    @Test
    public void whenUpdateUserShouldUpdateUserInStorage() {
        User user = new User();
        user.setName("admin");
        int index = importUser.addUser(user);
        user.setName("root");
        importUser.updateUser(user);
        assertThat(importUser.getUser(index), is(user));
    }

    /**
     * Test delete method.
     */
    @Test
    public void whenDeleteUserShouldRemoveUserFromStorage() {
        User user = new User();
        user.setName("admin");
        int index = importUser.addUser(user);
        user.setId(index);
        importUser.deleteUser(user);
        assertNull(importUser.getUser(index));
    }

    /**
     * Test getById method.
     */
    @Test
    public void whenGetUserShouldReturnUserFromStorage() {
        User user = new User();
        user.setName("admin");
        int index = importUser.addUser(user);
        user.setId(index);
        assertThat(importUser.getUser(index), is(user));
    }

    /**
     * Test getAllUsers method.
     */
    @Test
    public void whenGetUsersShouldReturnUserList() {
        User admin = new User();
        admin.setName("admin");
        User root = new User();
        root.setName("root");
        int adminIndex = importUser.addUser(admin);
        int rootIndex = importUser.addUser(root);
        admin.setId(adminIndex);
        root.setId(rootIndex);
        List<User> expected = new ArrayList<>();
        expected.add(admin);
        expected.add(root);
        assertThat(importUser.getUsers(), is(expected));
    }
}
