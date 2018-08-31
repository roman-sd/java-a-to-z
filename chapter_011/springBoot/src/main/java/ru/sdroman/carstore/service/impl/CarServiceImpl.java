package ru.sdroman.carstore.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sdroman.carstore.domain.Body;
import ru.sdroman.carstore.domain.Car;
import ru.sdroman.carstore.domain.DriveType;
import ru.sdroman.carstore.domain.Engine;
import ru.sdroman.carstore.domain.Model;
import ru.sdroman.carstore.domain.Transmission;
import ru.sdroman.carstore.repository.BodyRepository;
import ru.sdroman.carstore.repository.CarRepository;
import ru.sdroman.carstore.repository.DriveTypeRepository;
import ru.sdroman.carstore.repository.EngineRepository;
import ru.sdroman.carstore.repository.ModelRepository;
import ru.sdroman.carstore.repository.TransmissionRepository;
import ru.sdroman.carstore.service.CarService;

import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
@Component
public class CarServiceImpl implements CarService {

    /**
     * Car repository.
     */
    private CarRepository carRepo;

    /**
     * Body repository.
     */
    private BodyRepository bodyRepo;

    /**
     * DriveType repository.
     */
    private DriveTypeRepository driveTypeRepo;

    /**
     * Engine repository.
     */
    private EngineRepository engineRepo;

    /**
     * Model repository.
     */
    private ModelRepository modelRepo;

    /**
     * Transmission repository.
     */
    private TransmissionRepository transmissionRepo;

    /**
     * Constructor.
     *
     * @param carRepo          Car repository
     * @param bodyRepo         Body repository
     * @param driveTypeRepo    DriveType repository
     * @param engineRepo       Engine repository
     * @param modelRepo        Model repository
     * @param transmissionRepo Transmission repository
     */
    @Autowired
    public CarServiceImpl(CarRepository carRepo, BodyRepository bodyRepo, DriveTypeRepository driveTypeRepo,
                          EngineRepository engineRepo, ModelRepository modelRepo, TransmissionRepository transmissionRepo) {
        this.carRepo = carRepo;
        this.bodyRepo = bodyRepo;
        this.driveTypeRepo = driveTypeRepo;
        this.engineRepo = engineRepo;
        this.modelRepo = modelRepo;
        this.transmissionRepo = transmissionRepo;
    }

    @Override
    public Car add(Car car) {
        return this.carRepo.save(car);
    }

    @Override
    public Car update(Car car) {
        return this.carRepo.save(car);
    }

    @Override
    public void delete(Car car) {
        this.carRepo.delete(car);
    }

    @Override
    public Car getCar(int id) {
        return this.carRepo.findById(id).orElse(null);
    }

    @Override
    public List<Car> getCars() {
        return Lists.newArrayList(this.carRepo.findAll());
    }

    @Override
    public List<Body> getBodies() {
        return Lists.newArrayList(this.bodyRepo.findAll());
    }

    @Override
    public Body getBodyById(int id) {
        return this.bodyRepo.findById(id).orElse(null);
    }

    @Override
    public List<DriveType> getDriveType() {
        return Lists.newArrayList(this.driveTypeRepo.findAll());
    }

    @Override
    public DriveType getDriveTypeById(int id) {
        return this.driveTypeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Engine> getEngines() {
        return Lists.newArrayList(this.engineRepo.findAll());
    }

    @Override
    public Engine getEngineById(int id) {
        return this.engineRepo.findById(id).orElse(null);
    }

    @Override
    public List<Model> getModels() {
        return Lists.newArrayList(this.modelRepo.findAll());
    }

    @Override
    public Model getModelById(int id) {
        return this.modelRepo.findById(id).orElse(null);
    }

    @Override
    public List<Transmission> getTransmissions() {
        return Lists.newArrayList(this.transmissionRepo.findAll());
    }

    @Override
    public Transmission getTransmissionById(int id) {
        return this.transmissionRepo.findById(id).orElse(null);
    }
}
