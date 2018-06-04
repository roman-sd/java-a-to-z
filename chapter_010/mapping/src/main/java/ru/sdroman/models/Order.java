package ru.sdroman.models;

import java.sql.Timestamp;

/**
 * @author sdroman
 * @since 06.2018
 */
public class Order {

    /**
     * Id.
     */
    private int id;

    /**
     * Is sold.
     */
    private boolean sold;

    /**
     * Price.
     */
    private int price;

    /**
     * Date create.
     */
    private Timestamp created;

    /**
     * Car.
     */
    private Car car;

    /**
     * User.
     */
    private User user;

    /**
     * Constructor.
     */
    public Order() {
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
     * Returs sold.
     *
     * @return boolean
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Sets sold.
     *
     * @param sold boolean
     */
    public void setSold(boolean sold) {
        this.sold = sold;
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
     * Returns date create.
     *
     * @return Timestamp
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Sets date create.
     *
     * @param created Timestamp
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * Returns car.
     *
     * @return Car
     */
    public Car getCar() {
        return car;
    }

    /**
     * Sets car.
     *
     * @param car Car
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Returns user.
     *
     * @return User
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user User
     */
    public void setUser(User user) {
        this.user = user;
    }
}
