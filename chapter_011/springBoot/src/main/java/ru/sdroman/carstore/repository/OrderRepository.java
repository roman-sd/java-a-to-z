package ru.sdroman.carstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sdroman.carstore.domain.Order;

/**
 * @author sdroman
 * @since 08.2018
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
