package sdroman.controllers;

import org.junit.Test;
import sdroman.database.DataSource;
import sdroman.database.UserStore;
import sdroman.model.Role;
import sdroman.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class UpdateControllerTest {

    /**
     * Test update controller.
     *
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Test
    public void doPost() throws ServletException, IOException {
        UserStore userStore = new UserStore(DataSource.getInstance().getPool());
        User user =
                new User("root", "root", "root", "root", new Timestamp(System.currentTimeMillis()), Role.USER);
        userStore.addUser(user);
        UpdateController controller = new UpdateController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("test");
        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("password")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");
        when(request.getParameter("role")).thenReturn("GUEST");
        controller.init();
        controller.doPost(request, response);

        verify(request, atLeast(1)).getParameter("name");
        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("password");
        verify(request, atLeast(1)).getParameter("email");
        verify(request, atLeast(1)).getParameter("role");

        User actualUser = userStore.getUserByLogin("root");
        userStore.removeUser(actualUser);

        assertThat(actualUser.getName(), is("test"));
        assertThat(actualUser.getLogin(), is("root"));
        assertThat(actualUser.getPassword(), is("test"));
        assertThat(actualUser.getEmail(), is("test"));
        assertThat(actualUser.getRole(), is(Role.GUEST));
    }
}
