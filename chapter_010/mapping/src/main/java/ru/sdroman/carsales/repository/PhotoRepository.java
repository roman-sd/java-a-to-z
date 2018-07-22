package ru.sdroman.carsales.repository;

import ru.sdroman.carsales.models.Photo;

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
}
