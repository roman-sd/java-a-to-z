package ru.sdroman.carstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sdroman.carstore.services.OrderService;

/**
 * @author sdroman
 * @since 08.2018
 */
@Controller
public class MainController {

    private OrderService orderService;

    @Autowired
    public MainController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/")
    public ModelAndView getOrders(Model model) {
        return new ModelAndView("index", "orders", this.orderService.getOrders());
    }
}
