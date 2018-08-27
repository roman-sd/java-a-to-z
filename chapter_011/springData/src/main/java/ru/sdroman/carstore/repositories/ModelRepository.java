package ru.sdroman.carstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sdroman.carstore.models.Brand;

/**
 * @author sdroman
 * @since 08.2018
 */
@Repository
public interface ModelRepository extends CrudRepository<Brand, Integer> {
}
