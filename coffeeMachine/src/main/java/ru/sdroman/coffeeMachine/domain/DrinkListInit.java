package ru.sdroman.coffeeMachine.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Init and returns drinkList.
 *
 * @author sdroman
 * @since 09.2018
 */
public class DrinkListInit {

    private static final List<Drink> DRINKS = new ArrayList<>();

    static {
        initData();
    }

    /**
     * DrinkList initialization.
     */
    private static void initData() {
        DRINKS.add(new Drink(0, "cappuccino", new Ingredients(-150, -100, -15)));
        DRINKS.add(new Drink(1, "espresso", new Ingredients(-100, 0, -10)));
        DRINKS.add(new Drink(2, "latte", new Ingredients(-100, -100, -10)));
    }

    /**
     * Returns drinkList.
     *
     * @return drinkList
     */
    public List<Drink> getDrinks() {
        return DRINKS;
    }
}
