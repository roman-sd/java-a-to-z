package ru.sdroman.pro.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test BaseStore class.
 * @author sdroman
 * @since 04.17
 */
public class BaseStoreTest {

    /**
     * BaseStore instance.
     */
    private BaseStore baseStore;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        baseStore = new BaseStore();
        baseStore.add(new User("001"));
    }

    /**
     * Test add method.
     * @throws ElementNotFoundException exception
     */
    @Test
    public void whenAddCallThenAddsElement() throws ElementNotFoundException {
        Base user = new User("002");
        baseStore.add(user);
        assertThat(baseStore.get("002"), is(user));
    }

    /**
     * Test remove method.
     * @throws ElementNotFoundException exception
     */
    @Test(expected = ElementNotFoundException.class)
    public void whenRemoveCallThenDeleteElementById() throws ElementNotFoundException {
        baseStore.add(new Role("002"));
        baseStore.remove("002");
        baseStore.get("002");
    }

    /**
     * Test get method.
     * @throws ElementNotFoundException exception
     */
    @Test
    public void whenGetCallThenReturnsElementById() throws ElementNotFoundException {
        Base role = new Role("002");
        baseStore.add(role);
        assertThat(baseStore.get("002"), is(role));
    }

    /**
     * Test update method.
     * @throws ElementNotFoundException exception
     */
    @Test
    public void whenUpdateCallThenSetsNewValue() throws ElementNotFoundException {
        baseStore.add(new User("003"));
        Base newUser = new User("007");
        baseStore.update("003", newUser);
        assertThat(baseStore.get("007"), is(newUser));
    }
}
