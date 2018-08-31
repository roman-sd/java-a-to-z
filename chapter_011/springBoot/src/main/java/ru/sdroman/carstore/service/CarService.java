package ru.sdroman.carstore.service;


import ru.sdroman.carstore.domain.Body;
import ru.sdroman.carstore.domain.Car;
import ru.sdroman.carstore.domain.DriveType;
import ru.sdroman.carstore.domain.Engine;
import ru.sdroman.carstore.domain.Model;
import ru.sdroman.carstore.domain.Transmission;

import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
public interface CarService {

    /**
     * Returns body list.
     *
     * @return List
     */
    List<Body> getBodies();

    /**
     * Returns body by id.
     *
     * @param id int
     * @return Body
     */
    Body getBodyById(int id);

    /**
     * Returns engine list.
     *
     * @return List
     */
    List<Engine> getEngines();

    /**
     * Returns engine by id.
     *
     * @param id int
     * @return Engine
     */
    Engine getEngineById(int id);

    /**
     * Returns driveType list.
     *
     * @return List
     */
    List<DriveType> getDriveType();

    /**
     * Returns driveType by id.
     *
     * @param id int
     * @return DriveType
     */
    DriveType getDriveTypeById(int id);

    /**
     * Returns model list.
     *
     * @return List
     */
    List<Model> getModels();

    /**
     * Returns model by id.
     *
     * @param id int
     * @return Model
     */
    Model getModelById(int id);

    /**
     * Returns transmission list.
     *
     * @return List
     */
    List<Transmission> getTransmissions();

    /**
     * Returns transmission by id.
     *
     * @param id int
     * @return Transmission
     */
    Transmission getTransmissionById(int id);

    /**
     * Returns car list.
     *
     * @return List
     */
    List<Car> getCars();

    /**
     * Returns car by id.
     *
     * @param id int
     * @return Car
     */
    Car getCar(int id);

    /**
     * Adds car to db.
     *
     * @param car Car without id
     * @return Car with id.
     */
    Car add(Car car);

    /**
     * Removes car from db.
     *
     * @param car Car
     */
    void delete(Car car);

    /**
     * Updates car.
     *
     * @param car Car
     * @return new Car
     */
    Car update(Car car);
}
