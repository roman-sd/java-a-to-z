package sdroman.controllers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sdroman.models.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @author sdroman
 * @since 04.2018
 */
public class JsonRoles extends HttpServlet {

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
        resp.setContentType("text/json");
        List<Role> roles = Arrays.asList(Role.values());
        Gson gsonBuilder = new GsonBuilder().create();
        String gson = gsonBuilder.toJson(roles);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(gson);
        writer.flush();
    }
}
