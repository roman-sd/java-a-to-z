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
public class AddUser extends HttpServlet {

    /**
     * Database.
     */
    private UserStore userStore;

    /**
     * Init servlet.
     * @throws ServletException exception
     */
    @Override
    public void init() throws ServletException {
        userStore = new UserStore();
    }

    /**
     * GET.
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Users servlet</title></head>");
        out.println("<body>");
        out.println("<h3>Add new user</h3>");
        out.println("<form action=\"./create\" method=\"POST\">");
        out.println("<table>");
        out.println("<tr><th>Name</th>");
        out.println("<td><input type=\"text\" name=\"name\"></td></tr>");
        out.println("<tr><th>Login</th>");
        out.println("<td><input type=\"text\" name=\"login\"></td></tr>");
        out.println("<tr><th>email</th>");
        out.println("<td><input type=\"text\" name=\"email\"></td></tr>");
        out.println("</table>");
        out.println("<input type=\"submit\" value=\"Add\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * POST.
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userStore.addUser(new User(
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                new Timestamp(System.currentTimeMillis())
        ));
        resp.sendRedirect("./users");
    }
}
