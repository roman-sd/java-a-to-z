package ru.sdroman.carsales.repository;

import org.junit.Test;
import ru.sdroman.carsales.models.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sdroman
 * @since 07.2018
 */
public class UserRepositoryTest {

    /**
     * UserRepository class test.
     */
    @Test
    public void userRepositoryTest() {
        UserRepository repository = new UserRepository();
        User user = new User();
        user.setLogin("admin");
        int expectedId = 1;

        int actualId = repository.addUser(user);
        User actualUser = repository.getUserByLogin("admin");

        assertThat(actualId, is(expectedId));
        assertThat(actualUser, is(user));
    }
}
