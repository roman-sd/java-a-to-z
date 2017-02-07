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
 * Test for BotClient class.
 */
public class BotClientTest {

    /**
     * Test clientRun method().
     * @throws IOException exception
     */
    @Test
    public void whenAskThenReturn() throws IOException {
        final String sep = System.getProperty("line.separator");
        Socket socket = mock(Socket.class);
        ByteArrayInputStream input = new ByteArrayInputStream(((
                Joiner.on(sep).join("hi", "", "exit")).getBytes()));
        System.setIn(input);

        ByteArrayInputStream in = new ByteArrayInputStream(
                Joiner.on(sep).join("I don't understand", "", "", "").getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        BotClient client = new BotClient(socket);
        client.clientRun();
        assertThat(out.toString(), is(Joiner.on(sep).join("hi", "", "exit", "")));
    }
}
