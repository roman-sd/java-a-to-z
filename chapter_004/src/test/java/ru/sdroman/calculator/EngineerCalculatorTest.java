package ru.sdroman.calculator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test EngineerCalculator class.
 *
 * @author sdroman
 * @version 0.1
 * @since 02.17
 */
public class EngineerCalculatorTest {

    /**
     * Calculator.
     */
    private Calculator calculator;

    /**
     * InteractCalculator.
     */
    private Menu menu;

    /**
     * SetUp.
     *
     * @param iterator Iterator<String>
     */
    public void setUp(Iterator<String> iterator) {
        final Output output = new StubOutput();
        Input input = new StubInput(iterator, output);
        this.calculator = new EngineerCalculator();
        this.menu = new Menu(input, output, calculator);
    }

    /**
     * Test Sin.
     */
    @Test
    public void whenSinThenReturnResult() {
        String halfPi = String.valueOf(Math.PI / 2);
        setUp(Arrays.asList("sin", halfPi, "y").iterator());
        final double expected = 1;
        menu.run();
        assertThat(calculator.getResult(), is(expected));
    }

    /**
     * Test Cos.
     */
    @Test
    public void whenCosThenReturnResult() {
        String pi = String.valueOf(Math.PI);
        setUp(Arrays.asList("cos", pi, "y").iterator());
        final double expected = -1;
        menu.run();
        assertThat(calculator.getResult(), is(expected));
    }
}
