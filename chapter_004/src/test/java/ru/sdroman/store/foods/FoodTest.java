package ru.sdroman.store.foods;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Food class.
 */
public class FoodTest {

    /**
     * Date create.
     */
    private LocalDate createDate;

    /**
     * Date expiry.
     */
    private LocalDate expiryDate;

    /**
     * Setup dates.
     * @param createDay int before
     * @param expiryDay int after
     */
    public void setDate(int createDay, int expiryDay) {
        LocalDate today = LocalDate.now();
        createDate = today.minusDays(createDay);
        expiryDate = today.plusDays(expiryDay);
    }

    /**
     * Test getPrice() method.
     *
     * @throws Exception exception
     */
    @Test
    public void whenGetPriceThenReturnPrice() throws Exception {
        final int createDays = 3;
        final int expiryDays = 25;
        setDate(createDays, expiryDays);
        Food food = new Fruit("apple", createDate.toString(), expiryDate.toString());
        final double price = 100;
        food.setPrice(price);
        final double expected = 100;
        assertThat(food.getPrice(), is(expected));
    }

    /**
     * Test getPrice() with discount.
     */
    @Test
    public void whenGetPriceThenDiscount() {
        final int createDays = 25;
        final int expiryDays = 3;
        setDate(createDays, expiryDays);
        Food food = new Fruit("apple", createDate.toString(), expiryDate.toString());
        final double price = 100;
        final double discount = 0.3;
        final double expected = 70;
        food.setPrice(price);
        food.setDiscount(discount);
        assertThat(food.getPrice(), is(expected));
    }
}