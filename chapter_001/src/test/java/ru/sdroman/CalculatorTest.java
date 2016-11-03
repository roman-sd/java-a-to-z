package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void whenAddThenAddition() {
        Calculator calc = new Calculator();
        calc.add(6, 3);
        assertThat(calc.getResult(), is(9d));
    }

    @Test
    public void whenSubstructThenSubstraction() {
        Calculator calc = new Calculator();
        calc.substruct(6, 3);
        assertThat(calc.getResult(), is(3d));
    }

    @Test
    public void whenDivThenDivision() {
        Calculator calc = new Calculator();
        calc.div(6, 3);
        assertThat(calc.getResult(), is(2d));
    }

    @Test
    public void whenMultipleThenMultiplication() {
        Calculator calc = new Calculator();
        calc.multiple(6, 3);
        assertThat(calc.getResult(), is(18d));
    }

}