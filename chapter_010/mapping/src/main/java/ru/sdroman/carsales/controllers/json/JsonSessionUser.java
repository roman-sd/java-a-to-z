package ru.sdroman.carsales.controllers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sdroman.carsales.models.User;
import ru.sdroman.carsales.serializers.UserSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sdroman
 * @since 06.2018
 */
public class JsonSessionUser extends HttpServlet {

    /**
     * Get.
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
        User user = (User) session.getAttribute("currentUser");
        Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new UserSerializer()).create();
        String json = gson.toJson(user);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(json);
        writer.flush();
    }
}
