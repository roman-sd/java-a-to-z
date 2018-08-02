package ru.sdroman.springbeans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * @author sdroman
 * @since 08.2018
 */
public class UserStorageTest {

    /**
     * Test add method.
     */
    @Test
    public void whenAddUserToStorageShouldSafeIt() {
        Storage memory = new MemoryStorage();
        UserStorage userStorage = new UserStorage(memory);
        userStorage.addUser(new User());
    }

    /**
     * Test gets bean by spring context.
     */
    @Test
    public void whenLoadContextShouldGetBeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage memory = context.getBean(UserStorage.class);
        memory.addUser(new User());
        assertNotNull(memory);
    }
}
