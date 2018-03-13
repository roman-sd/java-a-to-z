package sdroman.servlets;

import sdroman.database.UserStore;
import sdroman.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * @author sdroman
 * @since 03.2018
 */
public class UpdateUsers extends HttpServlet {

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
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        User user = new User(name, login, email, new Timestamp(System.currentTimeMillis()));

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Update</title></head>");
        out.println("<body>");
        out.println("<form action=\"./update\" method=\"POST\">");
        out.println("<table>");
        out.println(String.format("<tr><th>Name</th><td>%s</td><td><input type=\"text\" name=\"name\"></td></tr>", user.getName()));
        out.println(String.format("<tr><th>Login</th><td>%s</td><td>%s</td></tr>", user.getLogin(), user.getLogin()));
        out.println(String.format("<tr><th>email</th><td>%s</td><td><input type=\"text\" name=\"email\"></td></tr>", user.getEmail()));
        out.println("</table>");
        out.println(String.format("<input type=\"hidden\" name=\"login\" value=\"%s\">", user.getLogin()));
        out.println("<input type=\"submit\" value=\"update\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
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
        userStore.editUser(new User(
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                new Timestamp(System.currentTimeMillis())));
        resp.sendRedirect("./users");
    }
}
