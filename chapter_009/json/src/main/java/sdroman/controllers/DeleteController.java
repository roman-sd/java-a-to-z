package sdroman.controllers;

import sdroman.database.EnumDataSource;
import sdroman.database.UserStore;
import sdroman.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sdroman
 * @since 04.2018
 */
public class DeleteController extends HttpServlet {

    /**
     * Database.
     */
    private UserStore userStore;

    /**
     * Init servlet.
     *
     * @throws ServletException exception
     */
    @Override
    public void init() throws ServletException {
        userStore = new UserStore(EnumDataSource.INSTANCE.getPool());
    }

    /**
     * POST.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userStore.removeUser(new User(
                null,
                req.getParameter("login"),
                null,
                null,
                null,
                null,
                null,
                null));
        resp.sendRedirect(String.format("%s/items", req.getContextPath()));
    }
}
