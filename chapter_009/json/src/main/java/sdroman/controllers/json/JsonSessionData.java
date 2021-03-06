package sdroman.controllers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sdroman.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sdroman
 * @since 04.2018
 */
public class JsonSessionData extends HttpServlet {

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
        HttpSession session = req.getSession();
        Map<String, User> map = new HashMap<>();
        map.put("curUser", (User) session.getAttribute("curUser"));

        map.put("updateUser", (User) session.getAttribute("updateUser"));

        Gson gsonBuilder = new GsonBuilder().create();
        String gson = gsonBuilder.toJson(map);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(gson);
        writer.flush();
    }
}
