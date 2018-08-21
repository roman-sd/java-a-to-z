package ru.sdroman.carstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sdroman.carstore.models.Car;

/**
 * @author sdroman
 * @since 08.2018
 */
@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
}
