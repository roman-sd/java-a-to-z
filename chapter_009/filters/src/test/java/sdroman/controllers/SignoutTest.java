package sdroman.controllers;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author sdroman
 * @since 03.2018
 */
public class SignoutTest {

    /**
     * Test signOut.
     *
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Test
    public void doGet() throws ServletException, IOException {
        Signout controller = new Signout();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        controller.init();
        controller.doGet(request, response);

        verify(session).invalidate();
    }
}
