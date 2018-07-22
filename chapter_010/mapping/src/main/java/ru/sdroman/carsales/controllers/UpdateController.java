package ru.sdroman.carsales.controllers;

import ru.sdroman.carsales.models.Order;
import ru.sdroman.carsales.repository.OrderRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sdroman
 * @since 06.2018
 */
public class UpdateController extends HttpServlet {

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
        OrderRepo repository = new OrderRepo();
        Order order = repository.getOrderById(Integer.valueOf(req.getParameter("id")));
        order.setSold(Boolean.valueOf(req.getParameter("sold")));
        repository.updateOrder(order);
    }
}
