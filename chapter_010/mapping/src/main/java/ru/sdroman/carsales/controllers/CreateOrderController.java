package ru.sdroman.carsales.controllers;

import ru.sdroman.carsales.models.Car;
import ru.sdroman.carsales.models.Order;
import ru.sdroman.carsales.models.Photo;
import ru.sdroman.carsales.models.User;
import ru.sdroman.carsales.repository.BodyRepository;
import ru.sdroman.carsales.repository.CarRepository;
import ru.sdroman.carsales.repository.DriveTypeRepository;
import ru.sdroman.carsales.repository.EngineRepository;
import ru.sdroman.carsales.repository.ModelRepository;
import ru.sdroman.carsales.repository.OrderRepository;
import ru.sdroman.carsales.repository.PhotoRepository;
import ru.sdroman.carsales.repository.TransmissionRepository;
import ru.sdroman.carsales.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author sdroman
 * @since 06.2018
 */
public class CreateOrderController extends HttpServlet {

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
        HttpSession session = req.getSession();
        if (session.getAttribute("currentUser") != null) {
            req.getRequestDispatcher("/createOrder.html").forward(req, resp);
        }
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
        Car car = new Car();
        car.setYear(req.getParameter("year"));
        car.setBody(
                new BodyRepository()
                        .getBodyByName(
                                req.getParameter("body")));
        car.setModel(
                new ModelRepository()
                        .getModelByName(
                                req.getParameter("model")));
        car.setEngine(
                new EngineRepository()
                        .getEngineByName(req.getParameter("engine")));
        car.setTransmission(
                new TransmissionRepository()
                        .getTransmissionByName(req.getParameter("transmission")));
        car.setDriveType(
                new DriveTypeRepository()
                        .getDriveTypeByName(req.getParameter("drivetype")));
        new CarRepository().addCar(car);

        Order order = new Order();
        order.setDescription(req.getParameter("orderDesc"));
        order.setPrice(Integer.parseInt(req.getParameter("price")));
        order.setCreated(new Timestamp(System.currentTimeMillis()));
        order.setSold(false);
        order.setCar(car);

        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("currentUser");
        User user = new UserRepository().getUserByLogin(sessionUser.getLogin());
        order.setUser(user);
        int orderId = new OrderRepository().addOrder(order);
        order.setId(orderId);

        List<Photo> photoList = (List<Photo>) session.getAttribute("photoList");
        PhotoRepository photoRepo = new PhotoRepository();
        if (photoList != null && !photoList.isEmpty()) {
            for (Photo photo : photoList) {
                photo.setOrder(order);
                photoRepo.addPhotos(photo);
            }
            session.removeAttribute("photoList");
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
