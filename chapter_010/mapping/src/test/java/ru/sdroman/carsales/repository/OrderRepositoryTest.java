package ru.sdroman.carsales.repository;

import org.junit.Test;
import ru.sdroman.carsales.models.Car;
import ru.sdroman.carsales.models.Model;
import ru.sdroman.carsales.models.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author sdroman
 * @since 07.2018
 */
public class OrderRepositoryTest {

    /**
     * OrderRepository class test.
     */
    @Test
    public void orderRepositoryTest() {
        OrderRepository orderRepo = new OrderRepository();
        Model audi = new Model();
        audi.setName("audi");
        ModelRepository modelRepo = new ModelRepository();
        modelRepo.addModel(audi);
        Model bmw = new Model();
        bmw.setName("bmw");
        modelRepo.addModel(bmw);
        Car audiCar = new Car();
        audiCar.setModel(audi);
        audiCar.setYear("1976");
        Car bmwCar = new Car();
        bmwCar.setModel(bmw);
        CarRepository carRepo = new CarRepository();
        carRepo.addCar(audiCar);
        carRepo.addCar(bmwCar);
        Order audiOrder = new Order();
        audiOrder.setCar(audiCar);
        Order bmwOrder = new Order();
        bmwOrder.setCar(bmwCar);
        List<Order> defaultOrders = new ArrayList<>();
        defaultOrders.add(audiOrder);
        defaultOrders.add(bmwOrder);
        Map<String, String> param = new HashMap<>();
        param.put("model", "audi");
        int actualId = orderRepo.addOrder(audiOrder);
        orderRepo.addOrder(bmwOrder);

        List<Order> expectedList = new ArrayList<>();
        expectedList.add(defaultOrders.get(0));
        Order soldOrder = defaultOrders.get(1);
        soldOrder.setSold(true);
        orderRepo.updateOrder(soldOrder);

        assertThat(actualId, is(1));
        assertThat(orderRepo.getOrderById(1), is(audiOrder));
        assertTrue(orderRepo.getOrderById(2).isSold());
        assertThat(orderRepo.getOrdersByParameters(new HashMap<>()), is(defaultOrders));
        assertThat(orderRepo.getOrdersByParameters(param), is(expectedList));

        param.clear();
        param.put("year", "1976");

        assertThat(orderRepo.getOrdersByParameters(param), is(expectedList));

    }
}
