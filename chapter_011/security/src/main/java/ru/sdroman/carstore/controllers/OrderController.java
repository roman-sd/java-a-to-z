package ru.sdroman.carstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sdroman.carstore.models.Body;
import ru.sdroman.carstore.models.Car;
import ru.sdroman.carstore.models.DriveType;
import ru.sdroman.carstore.models.Engine;
import ru.sdroman.carstore.models.Order;
import ru.sdroman.carstore.models.OrderDTO;
import ru.sdroman.carstore.models.Transmission;
import ru.sdroman.carstore.services.CarService;
import ru.sdroman.carstore.services.OrderService;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
@Controller
public class OrderController {

    /**
     * OrderService.
     */
    private OrderService orderService;

    /**
     * CarService.
     */
    private CarService carService;


    /**
     * Constructor.
     *
     * @param orderService OrderService
     * @param carService   CarService
     */
    @Autowired
    public OrderController(OrderService orderService, CarService carService) {
        this.orderService = orderService;
        this.carService = carService;
    }

    /**
     * Orders form.
     *
     * @param model ModelMap
     * @return String
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrders(ModelMap model) {
        model.addAttribute("orders", this.orderService.getOrders());
        return "orders";
    }

    /**
     * Order details form.
     *
     * @param orderId Request parameter
     * @param model   Model
     * @return jsp
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
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
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model, @ModelAttribute("orderDTO") OrderDTO orderDTO) {
        model.addAttribute("newOrder", orderDTO);
        return "add";
    }

    /**
     * Adds order to db.
     *
     * @param orderDTO OrderDTO
     * @return redirect url
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("newOrder") OrderDTO orderDTO) {
        Car car = new Car();
        car.setYear(orderDTO.getYear());
        car.setModel(carService.getModelById(orderDTO.getModelId()));
        car.setEngine(carService.getEngineById(orderDTO.getModelId()));
        car.setTransmission(carService.getTransmissionById(orderDTO.getTransmissionId()));
        car.setDriveType(carService.getDriveTypeById(orderDTO.getDriveTypeId()));
        car.setBody(carService.getBodyById(orderDTO.getBodyId()));
        Car newCar = carService.add(car);

        Order order = new Order();
        order.setSold(false);
        order.setCar(newCar);
        order.setCreated(new Timestamp(System.currentTimeMillis()));
        order.setPrice(orderDTO.getPrice());
        order.setDescription(orderDTO.getDescription());
        orderService.create(order);
        return "redirect:/";
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
    public List<ru.sdroman.carstore.models.Model> getModels() {
        return this.carService.getModels();
    }
}
