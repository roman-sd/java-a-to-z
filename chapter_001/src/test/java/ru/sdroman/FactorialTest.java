package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void whenSetNumberThenGiveFactorial() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calculateFactorial(5), is(120L));
    }
}