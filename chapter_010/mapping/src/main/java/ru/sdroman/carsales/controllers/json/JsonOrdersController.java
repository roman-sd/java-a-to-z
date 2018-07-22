package ru.sdroman.carsales.controllers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sdroman.carsales.models.Car;
import ru.sdroman.carsales.models.Order;
import ru.sdroman.carsales.models.User;
import ru.sdroman.carsales.repository.OrderRepo;
import ru.sdroman.carsales.serializers.CarSerializer;
import ru.sdroman.carsales.serializers.OrderSerializer;
import ru.sdroman.carsales.serializers.UserSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sdroman
 * @since 06.2018
 */
public class JsonOrdersController extends HttpServlet {

    /**
     * Order repository.
     */
    private OrderRepo repository;

    /**
     * Map of parameters.
     */
    private Map<String, String> param;

    /**
     * Initialize.
     *
     * @throws ServletException exception
     */
    @Override
    public void init() throws ServletException {
        repository = new OrderRepo();
        param = new HashMap<>();
    }

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
                .registerTypeAdapter(Order.class, new OrderSerializer())
                .registerTypeAdapter(Car.class, new CarSerializer())
                .registerTypeAdapter(User.class, new UserSerializer())
                .create();
        String json = gson.toJson(repository.getOrdersByParameters(param));
        PrintWriter writer = resp.getWriter();
        writer.append(json);
        writer.flush();
    }

    /**
     * Post.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        param.put("model", req.getParameter("model"));
        param.put("body", req.getParameter("body"));
        param.put("engine", req.getParameter("engine"));
        param.put("driveType", req.getParameter("drivetype"));
        param.put("transmission", req.getParameter("transmission"));
        param.put("year", req.getParameter("year"));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
