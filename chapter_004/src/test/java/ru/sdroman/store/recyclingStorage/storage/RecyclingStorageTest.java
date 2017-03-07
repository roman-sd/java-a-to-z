package ru.sdroman.store.recyclingStorage.storage;

import org.junit.Test;
import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.recyclingStorage.foods.RecyclingFood;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test RecyclingStorage.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class RecyclingStorageTest {

    /**
     * Test checkQuality() method in RecyclingStorage.
     *
     * @throws StoreIsFullException exception
     */
    @Test
    public void checkQuality() throws StoreIsFullException {
        final int createDate = 20;
        final int expiryDate = -2;
        final LocalDate today = LocalDate.now();
        final LocalDate create = today.minusDays(createDate);
        final LocalDate expiry = today.plusDays(expiryDate);
        RecyclingFood food = new RecyclingFood("apple", create.toString(), expiry.toString(), false);
        RecyclingStorage storage = new RecyclingStorage("reStore", 1);
        boolean actual = storage.checkQuality(food);
        assertThat(actual, is(false));
    }

}