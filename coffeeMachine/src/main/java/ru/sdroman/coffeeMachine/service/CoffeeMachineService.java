package ru.sdroman.coffeeMachine.service;

import ru.sdroman.coffeeMachine.domain.CoffeeMachineStatus;
import ru.sdroman.coffeeMachine.domain.Ingredients;

/**
 * Service provider.
 *
 * @author sdroman
 * @since 09.2018
 */
public interface CoffeeMachineService {
    CoffeeMachineStatus getMachineStatus();

    void addProduct(Ingredients ingredients);

    void updateState(Ingredients coffee);

    void cleanMachine();
}
