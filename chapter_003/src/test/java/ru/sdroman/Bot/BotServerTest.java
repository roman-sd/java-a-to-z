package ru.sdroman.Bot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * For test BotServer class.
 * @author sdroman
 * @since 06.01.17
 * @version 0.1
 */
public class BotServerTest {

    /**
     * Line separator.
     */
    private final String separator = System.getProperty("line.separator");

    /**
     * For test.
     * @param input String
     * @param expected String
     * @throws IOException exception
     */
    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        BotServer botServer = new BotServer(socket);
        botServer.startServer();
        assertThat(out.toString(), is(expected));
    }

    /**
     * Test exit.
     * @throws IOException exception
     */
    @Test
    public void whenGiveExitThenExit() throws IOException {
        this.testServer("exit", "");
    }

    /**
     * Test ask "Hello oracle".
     * @throws IOException exception
     */
    @Test
    public void whenAskHelloThenReturnAnswer() throws IOException {
        this.testServer(Joiner.on(separator).join(
                "hello oracle",
                "exit"
                ),
                Joiner.on(separator).join(
                        "Hello, dear friend, I'm a oracle.",
                        "",
                        ""
                ));
    }

    /**
     * Test ask anything.
     * @throws IOException exception
     */
    @Test
    public void whenAskAnythingThenAnswerDontUnderstand() throws IOException {
        this.testServer(Joiner.on(separator).join(
                "hi",
                "exit"
                ),
                Joiner.on(separator).join(
                        "I don't understand",
                        "",
                        ""
                ));
    }
}