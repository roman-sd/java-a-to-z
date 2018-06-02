package ru.sdroman.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sdroman.repository.ItemRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sdroman
 * @since 05.2018
 */
public class Controller extends HttpServlet {

    /**
     * Repository.
     */
    private ItemRepository repo = new ItemRepository();

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
        Gson jsonBuilder = new GsonBuilder().create();
        String json = jsonBuilder.toJson(repo.getItems());
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(json);
        writer.flush();
    }
}
