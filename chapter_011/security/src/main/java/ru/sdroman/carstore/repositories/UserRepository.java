package ru.sdroman.carstore.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sdroman.carstore.models.User;

/**
 * @author sdroman
 * @since 08.2018
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * Returns user by username.
     *
     * @param name String
     * @return User
     */
    @Query("select u from users u where u.login=:name")
    User findByName(@Param("name") String name);
}
