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
public class AddControllerTest {

    /**
     * Test addController.
     *
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Test
    public void addUser() throws ServletException, IOException {
        AddController controller = new AddController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("root");
        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("password")).thenReturn("root");
        when(request.getParameter("email")).thenReturn("root");
        when(request.getParameter("createdate")).thenReturn(new Timestamp(System.currentTimeMillis()).toString());
        when(request.getParameter("role")).thenReturn("USER");
        controller.init();
        controller.doPost(request, response);

        verify(request, atLeast(1)).getParameter("name");
        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("password");
        verify(request, atLeast(1)).getParameter("email");
        verify(request, atLeast(1)).getParameter("role");

        UserStore userStore = new UserStore(DataSource.getInstance().getPool());
        User actualUser = null;
        for (User user : userStore.getUsers()) {
            if ("root".equals(user.getLogin()) && "root".equals(user.getPassword())) {
                actualUser = user;
            }
        }
        userStore.removeUser(actualUser);
        assert actualUser != null;
        assertThat(actualUser.getLogin(), is("root"));
        assertThat(actualUser.getName(), is("root"));
        assertThat(actualUser.getPassword(), is("root"));
        assertThat(actualUser.getEmail(), is("root"));
        assertThat(actualUser.getRole(), is(Role.USER));
    }
}
