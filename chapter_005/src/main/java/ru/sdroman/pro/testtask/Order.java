package ru.sdroman.pro.testtask;

import java.util.Objects;

/**
 * Class Order.
 * @author sdroman
 * @since 05.2017
 */
public class Order {
    /**
     * Book.
     */
    private String book;

    /**
     * Operation.
     */
    private String operation;

    /**
     * Price.
     */
    private double price;

    /**
     * Volume.
     */
    private int volume;

    /**
     * Id.
     */
    private int orderId;

    /**
     * Constructs a new Order object.
     * @param book String
     * @param operation String
     * @param price double
     * @param volume int
     * @param orderId int
     */
    public Order(String book, String operation, double price, int volume, int orderId) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.orderId = orderId;
    }

    /**
     * Returns book.
     * @return String
     */
    public String getBook() {
        return book;
    }

    /**
     * Returns operation.
     * @return String
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Returns price.
     * @return double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns volume.
     * @return int
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns id.
     * @return int
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets volume.
     * @param volume int
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Equals.
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        return orderId == order.orderId;
    }

    /**
     * Hashcode.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(orderId);
    }

    /**
     * ToString.
     * @return String
     */
    @Override
    public String toString() {
        return "Order{"
                + "book='" + book + '\''
                + ", operation='" + operation + '\''
                + ", price=" + price
                + ", volume=" + volume
                + ", orderId=" + orderId
                + '}' + System.getProperty("line.separator");
    }
}
