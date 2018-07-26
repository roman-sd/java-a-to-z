package ru.sdroman.carsales.repository;

import ru.sdroman.carsales.models.Photo;

import java.util.List;

/**
 * @author sdroman
 * @since 07.2018
 */
public class PhotoRepository extends Repository {

    /**
     * Adds photo to db.
     *
     * @param photo Photo
     */
    public void addPhotos(Photo photo) {
        super.execute(session -> session.save(photo));
    }

    /**
     * Returns photoList by order id.
     *
     * @param orderId int
     * @return List<Photo>
     */
    public List<Photo> getPhotoByOrderId(int orderId) {
        return (List<Photo>) super.execute(session -> session.createQuery("from Photo p where p.order.id=:id")
                .setParameter("id", orderId)
                .list());
    }

    /**
     * Returns order's photoList size.
     *
     * @param orderId int
     * @return Number
     */
    public Number photoListSize(int orderId) {
        return (Number) super.execute(session
                -> session.createQuery("select count(*) from Photo p where p.order.id=:id")
                .setParameter("id", orderId)
                .uniqueResult());
    }
}
