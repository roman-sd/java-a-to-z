package ru.sdroman.carsales.repository;

import org.junit.Test;
import ru.sdroman.carsales.models.Car;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sdroman
 * @since 07.2018
 */
public class CarRepositoryTest {

    /**
     * CarRepository class test.
     */
    @Test
    public void carRepositoryTest() {
        CarRepository repository = new CarRepository();
        Car car = new Car();
        car.setYear("2016");

        int actualId = repository.addCar(car);
        Car actualCar = repository.getCarById(1);

        assertThat(actualId, is(1));
        assertThat(actualCar, is(car));
    }
}
