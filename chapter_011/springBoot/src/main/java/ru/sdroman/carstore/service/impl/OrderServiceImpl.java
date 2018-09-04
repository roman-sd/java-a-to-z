package ru.sdroman.carstore.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sdroman.carstore.domain.Order;
import ru.sdroman.carstore.repository.OrderRepository;
import ru.sdroman.carstore.service.OrderService;

import java.util.List;
import java.util.Optional;

/**
 * @author sdroman
 * @since 08.2018
 */

@Component
public class OrderServiceImpl implements OrderService {

    /**
     * Order repository.
     */
    private OrderRepository orderRepo;

    /**
     * Constructor.
     *
     * @param orderRepo Order repository
     */
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }


    @Override
    public Order create(Order order) {
        return this.orderRepo.save(order);
    }

    @Override
    public Order update(Order order) {
        return this.orderRepo.save(order);
    }

    @Override
    public void delete(Order order) {
        this.orderRepo.delete(order);
    }

    @Override
    public Order getOrder(int id) {
        Optional<Order> optional = this.orderRepo.findById(id);
        return optional.isPresent() ? optional.get() : new Order();
    }

    @Override
    public List<Order> getOrders() {
        return Lists.newArrayList(this.orderRepo.findAll());
    }
}
