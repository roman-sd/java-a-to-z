package ru.sdroman.coffeeMachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.sdroman.coffeeMachine.domain.Ingredients;
import ru.sdroman.coffeeMachine.domain.CoffeeMachineStatus;
import ru.sdroman.coffeeMachine.exception.IngredientException;
import ru.sdroman.coffeeMachine.exception.CleaningException;
import ru.sdroman.coffeeMachine.repository.CoffeeMachineRepository;

import java.util.Optional;

/**
 *
 * @author sdroman
 * @since 09.2018
 */
@Service
public class MachineService implements CoffeeMachineService {

    private final static int MAX_WATER = 2000;
    private final static int MAX_MILK = 1000;
    private final static int MAX_BEANS = 100;
    private final static int MAX_CAPS = 8;

    private CoffeeMachineRepository repository;

    @Autowired
    public MachineService(CoffeeMachineRepository repository) {
        this.repository = repository;
    }

    @Override
    public CoffeeMachineStatus getMachineStatus() {
        Optional<CoffeeMachineStatus> optional = repository.findById(1);
        return optional.isPresent() ? optional.get() : new CoffeeMachineStatus();
    }

    @Override
    public void updateState(Ingredients ingredients) {
        CoffeeMachineStatus status = checkMachine(ingredients);
        status.setCups(status.getCups() + 1);
        repository.save(status);
    }

    @Override
    public void addProduct(Ingredients ingredients) {
        repository.save(checkMachine(ingredients));
    }

    @Override
    public void cleanMachine() {
        CoffeeMachineStatus coffeeMachineStatus = getMachineStatus();
        coffeeMachineStatus.setWater(0);
        coffeeMachineStatus.setMilk(0);
        coffeeMachineStatus.setBeans(0);
        coffeeMachineStatus.setCups(0);
        repository.save(coffeeMachineStatus);
    }

    private CoffeeMachineStatus checkMachine(Ingredients coffee) {
        CoffeeMachineStatus state = getMachineStatus();
        if (state.getCups() == MAX_CAPS) {
            throw new CleaningException("Clean a coffee machine.");
        }
        int water = state.getWater() + coffee.getWater();
        int milk = state.getMilk() + coffee.getMilk();
        int beans = state.getBeans() + coffee.getBeans();

        if (water < 0 || milk < 0 || beans < 0 || water > MAX_WATER || milk > MAX_MILK || beans > MAX_BEANS) {
            StringBuilder msg = new StringBuilder("Error: ");
            if (water < 0 || water > MAX_WATER) {
                msg.append("water ");
            }
            if (milk < 0 || milk > MAX_MILK) {
                msg.append("milk ");
            }
            if (beans < 0 || beans > MAX_BEANS) {
                msg.append("beans");
            }
            throw new IngredientException(msg.toString());
        }
        state.setWater(water);
        state.setMilk(milk);
        state.setBeans(beans);
        return state;
    }
}
