package ru.sdroman.carsales.models;

/**
 * @author sdroman
 * @since 07.2018
 */
public class Photo {

    /**
     * Id.
     */
    private int id;

    /**
     * Photo
     */
    private byte[] images;

    /**
     * Order.
     */
    private Order order;

    /**
     * Returns id.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns photo.
     * @return array byte[]
     */
    public byte[] getImages() {
        return images;
    }

    /**
     * Sets photo.
     * @param images byte[]
     */
    public void setImages(byte[] images) {
        this.images = images;
    }

    /**
     * Returns order.
     * @return Order.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets order.
     * @param order Order
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
