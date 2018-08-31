package ru.sdroman.carstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sdroman.carstore.domain.Role;

/**
 * @author sdroman
 * @since 08.2018
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
