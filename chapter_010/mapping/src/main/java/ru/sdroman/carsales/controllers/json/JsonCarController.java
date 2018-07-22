package ru.sdroman.carsales.controllers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sdroman.carsales.models.Car;
import ru.sdroman.carsales.repository.CarRepo;
import ru.sdroman.carsales.serializers.CarSerializer;

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
public class JsonCarController extends HttpServlet {

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
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Car.class, new CarSerializer())
                .create();
        CarRepo repo = new CarRepo();
        Car car = repo.getCarById(1);
        String json = gson.toJson(car);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(json);
        writer.flush();
    }
}
