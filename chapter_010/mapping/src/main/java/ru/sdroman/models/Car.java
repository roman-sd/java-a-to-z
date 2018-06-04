package ru.sdroman.models;

import org.hibernate.Transaction;

/**
 * @author sdroman
 * @since 06.2018
 */
public class Car {

    /**
     * Id.
     */
    private int id;

    /**
     * Name.
     */
    private String name;

    /**
     * Body.
     */
    private Body body;

    /**
     * Model.
     */
    private Model model;

    /**
     * Engine.
     */
    private Engine engine;

    /**
     * DriveType.
     */
    private DriveType driveType;

    /**
     * Transmission.
     */
    private Transaction transaction;

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
     * Returns name.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
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
     * @return Transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Sets transaction.
     *
     * @param transaction Transaction
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
