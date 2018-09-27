package ru.sdroman.coffeeMachine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * CoffeeMachineStatus Model.
 *
 * @author sdroman
 * @since 09.2018
 */
@Entity(name = "status")
public class CoffeeMachineStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int water;
    private int milk;
    private int beans;
    private int cups;

    public CoffeeMachineStatus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCups() {

        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }
}
