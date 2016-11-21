package ru.sdroman;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    @Test
    public void whenSetFourThenPyramid() {
        Paint paint = new Paint();
        String expected = "    ^ \n" +
                "   ^ ^ \n" +
                "  ^ ^ ^ \n" +
                " ^ ^ ^ ^ \n";
        assertThat(paint.pyramid(4), is(expected));
    }
}
