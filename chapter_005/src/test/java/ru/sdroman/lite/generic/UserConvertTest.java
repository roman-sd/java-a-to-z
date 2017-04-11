package ru.sdroman.lite.generic;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test UserConvert class.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class UserConvertTest {

    /**
     * Test process method.
     */
    @Test
    public void whenSetUserListThenReturnHashMap() {
        final User user1 = new User("user1", 1, "Moscow");
        final User user2 = new User("user2", 2, "Paris");
        final User user3 = new User("user3", 3, "Monaco");
        final int idUser2 = 2;
        final int idUser3 = 3;
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> map = userConvert.process(Arrays.asList(user1, user2, user3));
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, user1);
        expected.put(idUser2, user2);
        expected.put(idUser3, user3);
        assertThat(map, is(expected));
    }
}
