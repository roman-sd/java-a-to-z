package ru.sdroman.carstore.models;

/**
 * @author sdroman
 * @since 08.2018
 */
public class OrderDTO {

    /**
     * Id.
     */
    private int id;

    /**
     * Description.
     */
    private String description;

    /**
     * Price.
     */
    private int price;

    /**
     * Year.
     */
    private String year;

    /**
     * Car body id.
     */
    private int bodyId;

    /**
     * Car engine id.
     */
    private int engineId;

    /**
     * Car model id.
     */
    private int modelId;

    /**
     * Car transmission id.
     */
    private int transmissionId;

    /**
     * Car drivetype id
     */
    private int driveTypeId;

    /**
     * Returns order id.
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Sets order id
     *
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns description.
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns price.
     *
     * @return int
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price int
     */
    public void setPrice(int price) {
        this.price = price;
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
     * Returns car body id.
     *
     * @return int
     */
    public int getBodyId() {
        return bodyId;
    }

    /**
     * Sets car body id.
     *
     * @param bodyId int
     */
    public void setBodyId(int bodyId) {
        this.bodyId = bodyId;
    }

    /**
     * Returns car engine id.
     *
     * @return int
     */
    public int getEngineId() {
        return engineId;
    }

    /**
     * Sets car engine id
     *
     * @param engineId int
     */
    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    /**
     * Returns car model id.
     *
     * @return int
     */
    public int getModelId() {
        return modelId;
    }

    /**
     * Sets car model id.
     *
     * @param modelId id
     */
    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    /**
     * Returns car transmission id.
     *
     * @return int
     */
    public int getTransmissionId() {
        return transmissionId;
    }

    /**
     * Sets car transmission id.
     *
     * @param transmissionId int
     */
    public void setTransmissionId(int transmissionId) {
        this.transmissionId = transmissionId;
    }

    /**
     * Returns drive type id.
     *
     * @return int
     */
    public int getDriveTypeId() {
        return driveTypeId;
    }

    /**
     * Sets car driveType id.
     *
     * @param driveTypeId int
     */
    public void setDriveTypeId(int driveTypeId) {
        this.driveTypeId = driveTypeId;
    }
}
