package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void whenSetXThenCalculateY() {
        Square square = new Square(1, 2, 3);
        assertThat(square.calculate(1), is(6.0F));
    }    
}