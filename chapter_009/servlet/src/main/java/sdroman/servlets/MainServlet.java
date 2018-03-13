package sdroman.servlets;

import sdroman.database.DataSource;
import sdroman.database.UserStore;
import sdroman.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author sdroman
 * @since 03.2018
 */
public class MainServlet extends HttpServlet {

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
        List<User> users = userStore.getUsers();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>UserServlet</title></head>");
        out.println("<body>");
        out.println("<p><strong>User list</strong></p>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Name</th><th>Login</th><th>email</th><th>date created</th><th>Actions</th>");
        out.println("</tr>");
        for (User user : users) {
            out.println("<tr>");
            out.println(new StringBuilder().append("<td>").append(user.getName()).append("</td>")
                    .append("<td>").append(user.getLogin()).append("</td>")
                    .append("<td>").append(user.getEmail()).append("</td>")
                    .append("<td>").append(new SimpleDateFormat("dd-MM-yy HH:mm").format(user.getCreateDate()))
                    .append("</td>"));
            out.println("<form>");
            out.println(String.format("<input type=\"hidden\" name=\"name\" value=\"%s\">", user.getName()));
            out.println(String.format("<input type=\"hidden\" name=\"login\" value=\"%s\">", user.getLogin()));
            out.println(String.format("<input type=\"hidden\" name=\"email\" value=\"%s\">", user.getEmail()));
            out.println("<td><button formaction=\"./update\" formmethod=\"GET\">update</button></td>");
            out.println("<td><button formaction=\"./delete\" formmethod=\"POST\">delete</button></td>");
            out.println("</form>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<br>");
        out.println("<b> <a href=\"./create\">Add new user</a> </b>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

    /**
     * Close servlet.
     */
    @Override
    public void destroy() {
        DataSource.getInstance().close();
    }
}
