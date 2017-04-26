package ru.sdroman.pro.list.queue;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test LinkedListQueue class.
 * @author sdroman
 * @since 04.17
 */
public class LinkedListQueueTest {

    /**
     * Queue.
     */
    private Queue<Integer> queue = new LinkedListQueue<>();

    /**
     * Test offer & poll methods.
     */
    @Test
    public void testQueue() {
        queue.offer(0);
        queue.offer(1);
        assertThat(queue.poll(), is(0));
        assertThat(queue.poll(), is(1));
    }
}
