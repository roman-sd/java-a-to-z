package ru.sdroman.carstore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author sdroman
 * @since 06.2018
 */
@Entity
@Table(name = "car")
public class Car {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    /**
     * Name.
     */
    @Column(name = "year")
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
    private Model model;

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
    public Model getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model Model
     */
    public void setModel(Model model) {
        this.model = model;
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

    /**
     * Equals.
     *
     * @param o Object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        if (id != car.id) {
            return false;
        }
        if (year != null ? !year.equals(car.year) : car.year != null) {
            return false;
        }
        if (body != null ? !body.equals(car.body) : car.body != null) {
            return false;
        }
        if (model != null ? !model.equals(car.model) : car.model != null) {
            return false;
        }
        if (engine != null ? !engine.equals(car.engine) : car.engine != null) {
            return false;
        }
        if (driveType != null ? !driveType.equals(car.driveType) : car.driveType != null) {
            return false;
        }
        return transmission != null ? transmission.equals(car.transmission) : car.transmission == null;
    }

    /**
     * HashCode.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (driveType != null ? driveType.hashCode() : 0);
        result = 31 * result + (transmission != null ? transmission.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", body=" + body +
                ", model=" + model +
                ", engine=" + engine +
                ", driveType=" + driveType +
                ", transmission=" + transmission +
                '}';
    }
}
