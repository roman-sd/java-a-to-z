package ru.sdroman.carstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sdroman.carstore.domain.Body;
import ru.sdroman.carstore.domain.DriveType;
import ru.sdroman.carstore.domain.Engine;
import ru.sdroman.carstore.domain.Order;
import ru.sdroman.carstore.domain.OrderDTO;
import ru.sdroman.carstore.domain.Transmission;
import ru.sdroman.carstore.domain.User;
import ru.sdroman.carstore.service.CarService;
import ru.sdroman.carstore.service.OrderService;
import ru.sdroman.carstore.service.UserService;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
@Controller
public class OrderController {

    /**
     * Order service.
     */
    private OrderService orderService;

    /**
     * Car service.
     */
    private CarService carService;

    /**
     * User service.
     */
    private UserService userService;


    /**
     * Constructor.
     *
     * @param orderService OrderService
     * @param carService   CarService
     * @param userService  UserService
     */
    @Autowired
    public OrderController(OrderService orderService, CarService carService, UserService userService) {
        this.orderService = orderService;
        this.carService = carService;
        this.userService = userService;
    }

    /**
     * Orders form.
     *
     * @param model ModelMap
     * @return String
     */
    @GetMapping("/index")
    public String getOrders(ModelMap model) {
        model.addAttribute("orders", this.orderService.getOrders());
        return "index";
    }

    /**
     * Order details form.
     *
     * @param orderId Request parameter
     * @param model   Model
     * @return jsp
     */
    @GetMapping("/order")
    public String orderInfo(@RequestParam("id") int orderId, Model model) {
        model.addAttribute(this.orderService.getOrder(orderId));
        return "info";
    }

    /**
     * Add order form.
     *
     * @param model    Model
     * @param orderDTO OrderDTO
     * @return jsp
     */
    @GetMapping("/add")
    public String getAddNewProductForm(Model model, @ModelAttribute("orderDTO") OrderDTO orderDTO) {
        model.addAttribute("newOrder", orderDTO);
        return "add";
    }

    /**
     * Adds order to db.
     *
     * @param orderDTO OrderDTO
     * @param principal Principal
     * @return redirect url
     */
    @PostMapping("/add")
    public String addOrder(@ModelAttribute("newOrder") OrderDTO orderDTO, Principal principal) {
        User user = userService.getUserByName(principal.getName());
        Order order = orderDTO.convertToOrder();
        order.setSold(false);
        order.setCreated(new Timestamp(System.currentTimeMillis()));
        order.setUser(user);
        carService.add(order.getCar());
        orderService.create(order);
        return "redirect:/index";
    }

    /**
     * Returns car bodies.
     *
     * @return List
     */
    @ModelAttribute("body")
    public List<Body> getBodies() {
        return this.carService.getBodies();
    }

    /**
     * Returns car engines.
     *
     * @return List
     */
    @ModelAttribute("engine")
    public List<Engine> getEngines() {
        return this.carService.getEngines();
    }

    /**
     * Returns car drivetype.
     *
     * @return List
     */
    @ModelAttribute("driveType")
    public List<DriveType> getDriveTypes() {
        return this.carService.getDriveType();
    }

    /**
     * Returns car transmissions.
     *
     * @return List
     */
    @ModelAttribute("transmission")
    public List<Transmission> getTransmission() {
        return this.carService.getTransmissions();
    }

    /**
     * Returns car model.
     *
     * @return List
     */
    @ModelAttribute("model")
    public List<ru.sdroman.carstore.domain.Model> getModels() {
        return this.carService.getModels();
    }
}
