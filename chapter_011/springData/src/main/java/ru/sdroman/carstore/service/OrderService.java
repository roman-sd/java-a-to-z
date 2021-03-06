package ru.sdroman.carstore.service;

import ru.sdroman.carstore.models.Order;

import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
public interface OrderService {

    /**
     * Creates and adds order to db.
     *
     * @param order Order without id
     * @return Order object with id
     */
    Order create(Order order);

    /**
     * Updates order.
     *
     * @param order Order
     * @return new order
     */
    Order update(Order order);

    /**
     * Removes order from db.
     *
     * @param order Order
     */
    void delete(Order order);

    /**
     * Returns order by id.
     *
     * @param id int
     * @return Order
     */
    Order get(int id);

    /**
     * Returns order list.
     *
     * @return List
     */
    List<Order> getAll();
}
