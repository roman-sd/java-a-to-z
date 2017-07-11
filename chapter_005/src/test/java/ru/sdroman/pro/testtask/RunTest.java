package ru.sdroman.pro.testtask;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Run class.
 * @author sdroman
 * @since 07.2017
 */
public class RunTest {

    /**
     * FileName.
     */
    private static final String FILENAME = "src\\test\\java\\ru\\sdroman\\resources\\orderTest.xml";

    /**
     * Test Run class.
     */
    @Test
    public void whenRunThenConsoleOut() {
        String separator = System.getProperty("line.separator");
        Splitter parser = new Splitter();
        parser.parse(FILENAME);
        Map<Integer, Order> map = parser.getMap();
        Run run = new Run();

        StringBuilder expected = new StringBuilder();
        expected.append(String.format("%7s %12s", "BID", "ASK")).append(separator)
                .append("Volume@Price – Volume@Price").append(separator)
                .append(String.format("%6s@%s", "400", "104.0"))
                .append(String.format("%8s@%s", "105.0", "500")).append(separator)
                .append(String.format("%6s@%s", "300", "102.0"))
                .append(String.format("%8s@%s", "107.0", "50"))
                .append(separator).append(separator);

        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        run.distOrders(map);

        assertThat(output.toString(), is(expected.toString()));
    }
}
