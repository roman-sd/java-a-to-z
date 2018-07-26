package ru.sdroman.carsales.models;

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
 * @since 07.2018
 */
@Entity
@Table(name = "photos")
public class Photo {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    /**
     * Photo.
     */
    @Column(name = "photolist")
    private byte[] images;

    /**
     * Order.
     */
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    /**
     * Constructor.
     */
    public Photo() {
    }

    /**
     * Returns id.
     *
     * @return int
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
     * Returns photo.
     *
     * @return array byte[]
     */
    public byte[] getImages() {
        return images;
    }

    /**
     * Sets photo.
     *
     * @param images byte[]
     */
    public void setImages(byte[] images) {
        this.images = images;
    }

    /**
     * Returns order.
     *
     * @return Order.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets order.
     *
     * @param order Order
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
