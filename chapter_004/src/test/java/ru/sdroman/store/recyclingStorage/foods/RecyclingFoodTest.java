package ru.sdroman.store.recyclingStorage.foods;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test RecyclingFood class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class RecyclingFoodTest {

    /**
     * Test canReproduct method.
     */
    @Test
    public void whenCanReproductThenReturnTrue() {
        RecyclingFood apple = new RFruit("apple", "2017-02-25", "2017-04-25", true);
        assertThat(apple.getCanReproduct(), is(true));
    }

    /**
     * Test canReproduct method.
     */
    @Test
    public void whenCanNotReproductThenReturnFalse() {
        RecyclingFood tomato = new RVegetables("tomato", "2017-02-25", "2017-04-25", false);
        assertThat(tomato.getCanReproduct(), is(false));
    }

}