package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class MaxLengthTest {

    @Test
    public void whenSetOneTwoThreeInMaxThenThree() {
       MaxLength maxLength = new MaxLength();
       assertThat(maxLength.max(1, 2, 3), is(3d));
    } 
}