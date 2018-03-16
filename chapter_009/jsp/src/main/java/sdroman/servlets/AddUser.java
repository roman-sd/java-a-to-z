package sdroman.servlets;

import sdroman.database.UserStore;
import sdroman.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author sdroman
 * @since 03.2018
 */
public class AddUser extends HttpServlet {

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
        userStore = new UserStore();
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
        resp.setContentType("text/html");
        this.getServletContext().getRequestDispatcher("/add.jsp").forward(req, resp);
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
                req.getParameter("email"),
                new Timestamp(System.currentTimeMillis())
        ));

        resp.sendRedirect("./");
    }
}
