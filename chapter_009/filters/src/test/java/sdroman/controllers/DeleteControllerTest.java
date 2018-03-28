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

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author sdroman
 * @since 03.2018
 */
public class DeleteControllerTest {

    /**
     * Test deleteController.
     *
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Test
    public void deleteController() throws ServletException, IOException {
        UserStore userStore = new UserStore(DataSource.getInstance().getPool());
        userStore.addUser(new User(null, "root", null, null, null, Role.ADMIN));
        DeleteController controller = new DeleteController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("login")).thenReturn("root");
        controller.init();
        controller.doPost(request, response);
        verify(request, atLeast(1)).getParameter("login");
        User user = userStore.getUserByLogin("root");
        assertNull(user);
    }
}
