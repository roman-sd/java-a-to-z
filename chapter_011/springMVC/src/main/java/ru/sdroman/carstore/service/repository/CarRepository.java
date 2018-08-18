package ru.sdroman.carstore.service.repository;

import ru.sdroman.carstore.models.Car;
import ru.sdroman.carstore.service.Repository;

/**
 * @author sdroman
 * @since 06.2018
 */
public class CarRepository extends Repository {

    /**
     * Returns car by name.
     *
     * @param id int
     * @return Car
     */
    public Car getCarById(int id) {
        return super.execute(session -> (Car) session.createQuery("from Car where id=:id")
                .setParameter("id", id)
                .uniqueResult());
    }

    /**
     * Adds car to db and returns id.
     *
     * @param car Car
     * @return int
     */
    public int addCar(Car car) {
        return super.execute(session -> (int) session.save(car));
    }
}
