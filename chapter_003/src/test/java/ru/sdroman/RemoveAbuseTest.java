package ru.sdroman;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class RemoveAbuse.
 * @author sdroman
 * @since 11.01.17
 * @version 1.0
 */
public class RemoveAbuseTest {

    /**
     * Test dropAbuse method.
     */
    @Test
    public void whenRemoveAbuseInStreamThenReturn() {
        RemoveAbuse removeAbuse = new RemoveAbuse();
        ByteArrayInputStream input = new ByteArrayInputStream("test remove abuse".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        removeAbuse.dropAbuse(input, out, new String[]{"test", "abuse"});
        String actual = " remove ";
        assertThat(actual, is(out.toString()));
    }
}
