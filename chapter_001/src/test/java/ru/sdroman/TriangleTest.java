package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleTest {
    Point x = new Point(1, 1);
    Point y = new Point(6, 1);
    Point z = new Point(1, 7);

    @Test
    public void whenSetThreePointsThenCalculateArea() {
        Triangle triangle = new Triangle(x, y, z);
        assertThat(triangle.area(), is(15d));
    }

    @Test
    public void whenSetTwoPointsThatCalculatDistance() {
        assertThat(x.distanceTo(y), is(5d));                
    }
}