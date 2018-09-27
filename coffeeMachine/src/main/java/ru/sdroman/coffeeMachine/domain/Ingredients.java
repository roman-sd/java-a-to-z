package ru.sdroman.coffeeMachine.domain;

/**
 * Class Ingredients.
 * Used in coffee machine and drinks classes.
 *
 * @author sdroman
 * @since 09.2018
 */
public class Ingredients {

    private int water;
    private int milk;
    private int beans;

    public Ingredients() {
    }

    public Ingredients(int water, int milk, int beans) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredients that = (Ingredients) o;

        if (water != that.water) return false;
        if (milk != that.milk) return false;
        return beans == that.beans;
    }

    @Override
    public int hashCode() {
        int result = water;
        result = 31 * result + milk;
        result = 31 * result + beans;
        return result;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "water=" + water +
                ", milk=" + milk +
                ", beans=" + beans +
                '}';
    }
}
