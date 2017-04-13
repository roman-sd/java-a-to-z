package ru.sdroman.lite.sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test SortUser class.
 *
 * @author sdroman
 * @since 04.17
 */
public class SortUserTest {

    /**
     * User1.
     */
    private User user1;

    /**
     * User2.
     */
    private User user2;

    /**
     * User3.
     */
    private User user3;

    /**
     * SetUp.
     */
    @Before
    public void setUp() {
        final int age1 = 53;
        final int age2 = 25;
        final int age3 = 30;
        user1 = new User("Sofia", age1);
        user2 = new User("Isabelle", age2);
        user3 = new User("Mia", age3);
    }

    /**
     * Test sort() method.
     */
    @Test
    public void sortTest() {
        SortUser sortUser = new SortUser();
        Set<User> users = sortUser.sort(Arrays.asList(user1, user2, user3));
        int age = 0;
        boolean done = true;
        for (User user : users) {
            if (age <= user.getAge()) {
                age = user.getAge();
            } else {
                done = false;
                break;
            }
        }
        assertThat(done, is(true));
    }

    /**
     * Test sortHash() method.
     */
    @Test
    public void sortHashTest() {
        SortUser sortUser = new SortUser();
        List<User> users = sortUser.sortHash(Arrays.asList(user1, user2, user3));
        int hashCode = 0;
        boolean done = true;
        for (User user : users) {
            if (hashCode <= user.hashCode()) {
                hashCode = user.hashCode();
            } else {
                done = false;
                break;
            }
        }
        assertThat(done, is(true));
    }

    /**
     * Test sortLength() method.
     */
    @Test
    public void sortLengthTest() {
        SortUser sortUser = new SortUser();
        List<User> actual = sortUser.sortLength(Arrays.asList(user1, user2, user3));
        List<User> expected = Arrays.asList(user3, user1, user2);
        assertThat(actual, is(expected));
    }
}
