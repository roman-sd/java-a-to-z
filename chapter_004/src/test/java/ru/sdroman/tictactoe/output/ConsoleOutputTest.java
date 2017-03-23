package ru.sdroman.tictactoe.output;

import org.junit.Test;
import ru.sdroman.tictactoe.interfaces.Output;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test ConsoleOutput class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class ConsoleOutputTest {

    /**
     * separator.
     */
    private static final String LN = System.getProperty("line.separator");

    /**
     * Test printField method.
     */
    @Test
    public void whenCallPrintFieldThenPrintField() {
        final int size = 3;
        int[][] testField = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                testField[i][j] = 1;
            }
        }
        String expected = "x\\y  0:  1:  2:" + LN
                + "    -----------" + LN
                + "0: | X | X | X | " + LN
                + "    -----------" + LN
                + "1: | X | X | X | " + LN
                + "    -----------" + LN
                + "2: | X | X | X | " + LN
                + "    -----------" + LN;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output output = new ConsoleOutput();
        output.printField(testField);
        assertThat(out.toString(), is(expected));
    }
}
