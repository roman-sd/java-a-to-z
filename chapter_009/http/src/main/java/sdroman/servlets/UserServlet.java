package sdroman.servlets;

import sdroman.database.UserStorage;
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
public class UserServlet extends HttpServlet {

    /**
     * Prepares tags to response.
     *
     * @param response HttpServletResponse
     * @throws IOException exception
     */
    private void prepareResponseTag(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!doctype !DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>UserServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>User list</h1>");
        for (User user : UserStorage.INSTANCE.getUsers()) {
            out.println(String.format("<tr> <td>%s<td>  <td>%s<td>  <td>%s<td>  <td>%s<td> </tr>",
                    user.getName(), user.getLogin(), user.getEmail(), user.getCreateDate()));
            out.println("<br>");
        }
        out.println("<br>");
        out.println("<form action=\"\" method=\"POST\">");
        out.println("<label>Actions</label>");
        out.println("<select id=\"actions\" name=\"actions\">");
        out.println("<option>select action</option>");
        out.println("<option>Add user</option>");
        out.println("<option>Edit user</option>");
        out.println("<option>Delete user</option>");
        out.println("</select>");
        out.println("<p>");
        out.println("<label>name</label>");
        out.println("<input type=\"text\" name=\"name\">");
        out.println("</p>");
        out.println("<p>");
        out.println("<label>login</label>");
        out.println("<input type=\"text\" name=\"login\">");
        out.println("</p>");
        out.println("<p>");
        out.println("<label>email</label>");
        out.println("<input type=\"text\" name=\"email\">");
        out.println("</p>");
        out.println("<button>submit</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
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
        prepareResponseTag(resp);
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
        String action = req.getParameter("actions");
        if ("Add user".equals(action)) {
            UserStorage.INSTANCE.addUser(new User(
                    req.getParameter("name"),
                    req.getParameter("login"),
                    req.getParameter("email"),
                    new Timestamp(System.currentTimeMillis())
            ));
        }
        if ("Edit user".equals(action)) {
            doPut(req, resp);
        }
        if ("Delete user".equals(action)) {
            doDelete(req, resp);
        }
        prepareResponseTag(resp);
    }

    /**
     * PUT.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserStorage.INSTANCE.editUser(new User(
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                new Timestamp(System.currentTimeMillis())
        ));
    }

    /**
     * DELETE.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserStorage.INSTANCE.removeUser(new User(
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                new Timestamp(System.currentTimeMillis())
        ));
    }
}
