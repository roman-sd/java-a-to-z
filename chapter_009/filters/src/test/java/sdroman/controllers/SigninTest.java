package sdroman.controllers;

import org.junit.Test;
import sdroman.database.DataSource;
import sdroman.database.UserStore;
import sdroman.model.Role;
import sdroman.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author sdroman
 * @since 03.2018
 */
public class SigninTest {

    /**
     * Test signIn controller.
     *
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Test
    public void doPostTestIfLogin() throws ServletException, IOException {
        UserStore userStore = new UserStore(DataSource.getInstance().getPool());
        User user = new User("root", "root", "root", "root", new Timestamp(System.currentTimeMillis()), Role.ADMIN);
        userStore.addUser(user);
        Signin controller = new Signin();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("password")).thenReturn("root");
        controller.init();
        controller.doPost(request, response);

        verify(request, atLeast(1)).getSession();
        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("password");

        userStore.removeUser(user);
    }

    /**
     * Test signIn controller.
     *
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Test
    public void doPostTestIfError() throws ServletException, IOException {
        Signin controller = new Signin();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getParameter("login")).thenReturn("qwerty");
        when(request.getParameter("password")).thenReturn("qwerty");
        when(request.getAttribute("error")).thenReturn("Login or password invalid");
        when(request.getRequestDispatcher("/WEB-INF/views/login.jsp")).thenReturn(dispatcher);
        controller.init();
        controller.doPost(request, response);

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("password");
        verify(request, atLeast(1)).getRequestDispatcher("/WEB-INF/views/login.jsp");

        assertThat(request.getAttribute("error"), is("Login or password invalid"));
    }
}
