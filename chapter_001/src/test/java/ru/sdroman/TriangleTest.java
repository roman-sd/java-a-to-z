package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleTest {
    
    @Test
    public void whenSetThreePointsThenCalculateArea() {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(6, 1), new Point(1, 7));
        assertThat(triangle.area(), is(15d));
    }

    @Test
    public void whenSetTwoPointsThatCalculatDistance() {
        assertThat(new Point(1, 1).distanceTo(new Point(6, 1)), is(5d));                
    }
}