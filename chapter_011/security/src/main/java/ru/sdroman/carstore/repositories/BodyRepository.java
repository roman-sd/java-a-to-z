package ru.sdroman.carstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sdroman.carstore.models.Body;

/**
 * @author sdroman
 * @since 08.2018
 */
@Repository
public interface BodyRepository extends CrudRepository<Body, Integer> {
}
