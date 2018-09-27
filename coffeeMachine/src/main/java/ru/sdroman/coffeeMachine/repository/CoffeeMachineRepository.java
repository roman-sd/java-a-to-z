package ru.sdroman.coffeeMachine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sdroman.coffeeMachine.domain.CoffeeMachineStatus;

/**
 * Repository provides CRUD functionality for the CoffeeMachineStatus class.
 *
 * @author sdroman
 * @since 09.2018
 */
@Repository
public interface CoffeeMachineRepository extends CrudRepository<CoffeeMachineStatus, Integer> {
}
