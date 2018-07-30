package ru.sdroman.carsales.repository;

import ru.sdroman.carsales.models.Car;

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
        return super.execute(session -> (Car) session.createQuery("from ru.sdroman.carsales.models.Car where id=:id")
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
        return (int) super.execute(session -> session.save(car));
    }
}
