package ru.sdroman.springbeans.models;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sdroman.springbeans.storages.ImportUser;
import ru.sdroman.springbeans.storages.MemoryStorage;
import ru.sdroman.springbeans.storages.Storage;

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
        ImportUser userStorage = new ImportUser(memory);
        userStorage.addUser(new User());
    }

    /**
     * Test gets bean by spring context.
     */
    @Test
    public void whenLoadContextShouldGetBeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ImportUser memory = context.getBean(ImportUser.class);
        memory.addUser(new User());
        assertNotNull(memory);
    }
}
