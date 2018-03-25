package sdroman.controllers;

import sdroman.database.DataSource;
import sdroman.database.UserStore;
import sdroman.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sdroman
 * @since 03.2018
 */
public class Signin extends HttpServlet {

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
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
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
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userStore.getUserByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("userRole", user.getRole());
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "Login or password invalid");
            doGet(req, resp);
        }
    }
}
