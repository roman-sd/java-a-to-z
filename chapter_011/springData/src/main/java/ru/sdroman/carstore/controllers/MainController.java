package ru.sdroman.carstore.controllers;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sdroman.carstore.models.Body;
import ru.sdroman.carstore.models.Brand;
import ru.sdroman.carstore.models.Car;
import ru.sdroman.carstore.models.DriveType;
import ru.sdroman.carstore.models.Engine;
import ru.sdroman.carstore.models.Order;
import ru.sdroman.carstore.models.OrderDTO;
import ru.sdroman.carstore.models.Transmission;
import ru.sdroman.carstore.service.CarService;
import ru.sdroman.carstore.service.OrderService;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
@Controller
public class MainController {

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
    public MainController(OrderService orderService, CarService carService) {
        this.orderService = orderService;
        this.carService = carService;
    }

    /**
     * Home.
     *
     * @param modelMap ModelMap
     * @return jsp
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String orderList(ModelMap modelMap) {
        modelMap.addAttribute("orders", Lists.newArrayList(this.orderService.getAll()));
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
        model.addAttribute(this.orderService.get(orderId));
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
        Brand brand = new Brand();
        brand.setId(orderDTO.getModelId());
        car.setBrand(brand);
        Engine engine = new Engine();
        engine.setId(orderDTO.getEngineId());
        car.setEngine(engine);
        Transmission transmission = new Transmission();
        transmission.setId(orderDTO.getTransmissionId());
        car.setTransmission(transmission);
        DriveType driveType = new DriveType();
        driveType.setId(orderDTO.getDriveTypeId());
        car.setDriveType(driveType);
        Body body = new Body();
        body.setId(orderDTO.getBodyId());
        car.setBody(body);
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
    public List<Brand> getModels() {
        return this.carService.getModels();
    }
}
