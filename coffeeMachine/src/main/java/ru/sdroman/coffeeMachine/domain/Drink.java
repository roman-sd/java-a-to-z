package ru.sdroman.coffeeMachine.domain;

/**
 * Drink model.
 *
 * @author sdroman
 * @since 09.2018
 */
public class Drink {

    private int id;
    private String name;
    private Ingredients ingredients;

    public Drink(int id, String name, Ingredients ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }
}
