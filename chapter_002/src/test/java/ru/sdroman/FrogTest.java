package ru.sdroman;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FrogTest.
 * @author sdroman
 * @since 30.12.2016
 * @version 1.0
 */
public class FrogTest {

    /**
     * Test Frog class.
     * @throws WayNotFoundException Exception
     */
    @Test
    public void whenFrogThenReturnWayArray() throws WayNotFoundException {
        Frog frog = new Frog();
        Point start = new Point(7, 11);
        Point finish = new Point(10, 9);
        Point[] trees = new Point[]{new Point(9, 14, -1), new Point(8, 5, -1)};
        frog.init(start, finish, trees);

        Point[] expected = new Point[]{new Point(10, 9, 8), new Point(8, 8, 7),
                new Point(6, 7, 6), new Point(5, 5, 5), new Point(5, 2, 4),
                new Point(5, 15, 3), new Point(5, 12, 2), new Point(7, 11, 1)};
        assertThat(expected, is(frog.resultArray(start)));
    }

    /**
     * Test Frog class.
     * @throws WayNotFoundException Exception
     */
    @Test
    public void whenFrogThenReturnWay2() throws WayNotFoundException {
        Frog frog = new Frog();
        Point start = new Point(1, 1);
        Point finish = new Point(5, 5);
        Point[] trees = new Point[]{new Point(2, 2, -1), new Point(1, 3, -1)};
        frog.init(start, finish, trees);
        Point[] expected = new Point[]{new Point(5, 5, 5), new Point(3, 4, 4),
                new Point(5, 3, 3), new Point(3, 2, 2), new Point(1, 1, 1)};
        assertThat(expected, is(frog.resultArray(start)));
    }

    /**
     * Test wayNotFoundException exception.
     * @throws WayNotFoundException Exception
     */
    @Test(expected = WayNotFoundException.class)
    public void whenFrogThenException() throws WayNotFoundException {
        Frog frog = new Frog();
        Point start = new Point(5, 0);
        Point finish = new Point(9, 7);
        Point[] trees = new Point[]{new Point(3, 1, -1), new Point(4, 2, -1),
                new Point(5, 3, -1), new Point(6, 2, -1), new Point(7, 1, -1)};
        frog.init(start, finish, trees);
        frog.resultArray(start);
    }

    /**
     * Test class Point.
     */
    @Test
    public void whenPointEqualsThenFalse() {
        Point start = new Point(1, 2);
        Point finish = new Point(3, 4);
        assertThat(false, is(start.equals(finish)));
    }
}
