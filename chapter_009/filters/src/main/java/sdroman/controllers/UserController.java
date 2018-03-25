package sdroman.controllers;

import sdroman.database.DataSource;
import sdroman.database.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sdroman
 * @since 03.2018
 */
public class UserController extends HttpServlet {

    /**
     * Database.
     */
    private UserStore userStore;

    /**
     * Init.
     *
     * @throws ServletException exception
     */
    @Override
    public void init() throws ServletException {
        userStore = new UserStore(DataSource.getInstance().getPool());
    }

    /**
     * GET.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userStore.getUsers());
        req.getRequestDispatcher("/WEB-INF/views/usersView.jsp").forward(req, resp);
    }
}
