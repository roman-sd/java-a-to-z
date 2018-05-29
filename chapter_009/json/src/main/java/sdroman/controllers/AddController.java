package sdroman.controllers;

import sdroman.database.EnumDataSource;
import sdroman.database.UserStore;
import sdroman.models.Role;
import sdroman.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author sdroman
 * @since 04.2018
 */
public class AddController extends HttpServlet {

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
     * GET.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("updateUser");
        req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
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
        userStore.addUser(new User(
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("password"),
                req.getParameter("email"),
                new Timestamp(System.currentTimeMillis()),
                Role.valueOf(req.getParameter("role")),
                req.getParameter("country"),
                req.getParameter("city")));
        resp.sendRedirect(String.format("%s/items", req.getContextPath()));
    }
}
