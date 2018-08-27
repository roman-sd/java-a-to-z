package ru.sdroman.carstore.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sdroman.carstore.models.Body;
import ru.sdroman.carstore.models.Car;
import ru.sdroman.carstore.models.DriveType;
import ru.sdroman.carstore.models.Engine;
import ru.sdroman.carstore.models.Brand;
import ru.sdroman.carstore.models.Transmission;
import ru.sdroman.carstore.repositories.BodyRepository;
import ru.sdroman.carstore.repositories.CarRepository;
import ru.sdroman.carstore.repositories.DriveTypeRepository;
import ru.sdroman.carstore.repositories.EngineRepository;
import ru.sdroman.carstore.repositories.ModelRepository;
import ru.sdroman.carstore.repositories.TransmissionRepository;

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
    public Car getById(int id) {
        return this.carRepo.findById(id).orElse(null);
    }

    @Override
    public List<Car> getAll() {
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
    public List<Brand> getModels() {
        return Lists.newArrayList(this.modelRepo.findAll());
    }

    @Override
    public Brand getModelById(int id) {
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
