package ru.sdroman.carstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sdroman.carstore.models.Body;
import ru.sdroman.carstore.models.Car;
import ru.sdroman.carstore.models.DriveType;
import ru.sdroman.carstore.models.Engine;
import ru.sdroman.carstore.models.Model;
import ru.sdroman.carstore.models.Order;
import ru.sdroman.carstore.models.OrderDTO;
import ru.sdroman.carstore.models.Transmission;
import ru.sdroman.carstore.service.repository.BodyRepository;
import ru.sdroman.carstore.service.repository.CarRepository;
import ru.sdroman.carstore.service.repository.DriveTypeRepository;
import ru.sdroman.carstore.service.repository.EngineRepository;
import ru.sdroman.carstore.service.repository.ModelRepository;
import ru.sdroman.carstore.service.repository.OrderRepository;
import ru.sdroman.carstore.service.repository.TransmissionRepository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
@Controller
public class UserController {

    /**
     * Home.
     *
     * @param modelMap ModelMap
     * @return jsp
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String orderList(ModelMap modelMap) {
        OrderRepository repo = new OrderRepository();
        modelMap.addAttribute("orders", repo.getOrdersByParameters(new HashMap<>()));
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
    public String orderInfo(@RequestParam("id") int orderId, org.springframework.ui.Model model) {
        Order order = new OrderRepository().getOrderById(orderId);
        model.addAttribute(order);
        return "info";
    }

    /**
     * Add order form.
     *
     * @param model Model
     * @param order OrderDTO
     * @return jsp
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addOrderForm(org.springframework.ui.Model model, @ModelAttribute OrderDTO order) {
        model.addAttribute("newOrder", order);
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
        car.setModel(new ModelRepository().getModelById(orderDTO.getModelId()));
        car.setBody(new BodyRepository().getBodyById(orderDTO.getBodyId()));
        car.setDriveType(new DriveTypeRepository().getDriveTypeById(orderDTO.getDriveTypeId()));
        car.setEngine(new EngineRepository().getEngineById(orderDTO.getEngineId()));
        car.setTransmission(new TransmissionRepository().getTransmissionById(orderDTO.getTransmissionId()));
        new CarRepository().addCar(car);
        Order order = new Order();
        order.setSold(false);
        order.setDescription(orderDTO.getDescription());
        order.setPrice(orderDTO.getPrice());
        order.setCreated(new Timestamp(System.currentTimeMillis()));
        order.setCar(car);
        new OrderRepository().addOrder(order);
        return "redirect:/";
    }

    /**
     * Returns car models.
     *
     * @return List
     */
    @ModelAttribute("model")
    public List<Model> getModels() {
        return new ModelRepository().getModels();
    }

    /**
     * Returns car bodies.
     *
     * @return List
     */
    @ModelAttribute("body")
    public List<Body> getBodies() {
        return new BodyRepository().getBodies();
    }

    /**
     * Returns car engines.
     *
     * @return List
     */
    @ModelAttribute("engine")
    public List<Engine> getEngines() {
        return new EngineRepository().getEngines();
    }

    /**
     * Returns car drivetype.
     *
     * @return List
     */
    @ModelAttribute("driveType")
    public List<DriveType> getDriveTypes() {
        return new DriveTypeRepository().getDriveTypes();
    }

    /**
     * Returns car transmissions.
     *
     * @return List
     */
    @ModelAttribute("transmission")
    public List<Transmission> getTransmission() {
        return new TransmissionRepository().getTransmissions();
    }
}
