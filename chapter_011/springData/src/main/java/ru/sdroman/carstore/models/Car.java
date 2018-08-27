package ru.sdroman.carstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author sdroman
 * @since 08.2018
 */
@Entity(name = "car")
public class Car {
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name.
     */
    private String year;

    /**
     * Body.
     */
    @ManyToOne
    @JoinColumn(name = "id_body")
    private Body body;

    /**
     * Model.
     */
    @ManyToOne
    @JoinColumn(name = "id_model")
    private Brand brand;

    /**
     * Engine.
     */
    @ManyToOne
    @JoinColumn(name = "id_engine")
    private Engine engine;

    /**
     * DriveType.
     */
    @ManyToOne
    @JoinColumn(name = "id_drivetype")
    private DriveType driveType;

    /**
     * Transmission.
     */
    @ManyToOne
    @JoinColumn(name = "id_transmission")
    private Transmission transmission;

    /**
     * Constructor.
     */
    public Car() {
    }

    /**
     * Constructs the new Car object.
     *
     * @param id int
     */
    public Car(int id) {
        this.id = id;
    }

    /**
     * Returns id.
     *
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns year.
     *
     * @return String
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year String
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Returns body.
     *
     * @return Body
     */
    public Body getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body Body
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * Returns model.
     *
     * @return Model model
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Sets model.
     *
     * @param brand Model
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Returns engine.
     *
     * @return Engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Sets engine.
     *
     * @param engine Engine
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * Returns drive type.
     *
     * @return DriveType
     */
    public DriveType getDriveType() {
        return driveType;
    }

    /**
     * Sets drivetype.
     *
     * @param driveType DriveType
     */
    public void setDriveType(DriveType driveType) {
        this.driveType = driveType;
    }

    /**
     * Returns transaction.
     *
     * @return Transmission
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     * Sets transaction.
     *
     * @param transmission Transmission
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

}
