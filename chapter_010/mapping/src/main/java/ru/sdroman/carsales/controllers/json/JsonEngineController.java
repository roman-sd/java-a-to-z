package ru.sdroman.carsales.controllers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sdroman.carsales.repository.EngineRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sdroman
 * @since 06.2018
 */
public class JsonEngineController extends HttpServlet {

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
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(new EngineRepository().getEngines());
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(json);
        writer.flush();
    }
}
