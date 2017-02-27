package ru.sdroman.calculator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test InteractCalculator class.
 *
 * @author sdroman
 * @version 0.1
 * @since 02.17
 */
public class InteractCalculatorTest {

    /**
     * Calculator.
     */
    private Calculator calculator;

    /**
     * InteractCalculator.
     */
    private InteractCalculator interactCalc;

    /**
     * SetUp.
     *
     * @param iterator Iterator<String>
     */
    private void setUp(Iterator<String> iterator) {
        final Output output = new StubOutput();
        Input input = new StubInput(iterator, output);
        calculator = new Calculator();
        interactCalc = new InteractCalculator(input, output, calculator);
    }

    /**
     * Test InteractCalculator & Calculator classes.
     */
    @Test
    public void whenAddThenReturnResult() {
        setUp(Arrays.asList("1", "+", "2", "n", "y").iterator());
        final double expected = 3;
        interactCalc.action();
        assertThat(calculator.getResult(), is(expected));
    }

    /**
     * Test InteractCalculator & Calculator classes.
     */

    @Test
    public void whenAddWithMemoryThenReturnResult() {
        setUp(Arrays.asList("5", "+", "3", "y", "m", "-", "1", "n", "y").iterator());
        final double expected = 7;
        interactCalc.action();
        assertThat(calculator.getResult(), is(expected));
    }

    /**
     * Test InteractCalculator & Calculator classes.
     */

    @Test
    public void whenDivThenReturnResult() {
        setUp(Arrays.asList("8", "/", "4", "n", "y").iterator());
        final double expected = 2;
        interactCalc.action();
        assertThat(calculator.getResult(), is(expected));
    }

    /**
     * Test InteractCalculator & Calculator classes.
     */

    @Test(expected = ArithmeticException.class)
    public void whenDivByZeroThenException() {
        setUp(Arrays.asList("8", "/", "0", "n", "y").iterator());
        interactCalc.action();
    }

    /**
     * Test InteractCalculator & Calculator classes.
     */

    @Test
    public void whenMultipleThenReturnResult() {
        setUp(Arrays.asList("2", "*", "4", "n", "y").iterator());
        final double expected = 8;
        interactCalc.action();
        assertThat(calculator.getResult(), is(expected));
    }

    /**
     * Test InteractCalculator & Calculator classes.
     */

    @Test
    public void whenSubtractionThenReturnResult() {
        setUp(Arrays.asList("5", "-", "3", "n", "y").iterator());
        final double expected = 2;
        interactCalc.action();
        assertThat(calculator.getResult(), is(expected));
    }

    /**
     * Test InteractCalculator & Calculator classes.
     */
    @Test(expected = NumberFormatException.class)
    public void whenSetNoOperationThenException() {
        final int num = 5;
        setUp(Arrays.asList("1", "&", "5", "n", "y").iterator());
        calculator.selectOperation("&", 1, num);
    }
}
