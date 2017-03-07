package ru.sdroman.store.recyclingStorage.storage;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.store.recyclingStorage.foods.RVegetables;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test FreezerWarehouse class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class FreezerWarehouseTest {

    /**
     * Date create.
     */
    private LocalDate createDate;

    /**
     * Date expiry.
     */
    private LocalDate expiryDate;

    /**
     * SetUp.
     */
    @Before
    public void setUp() {
        final int createDays = 1;
        final int expiryDays = 90;
        LocalDate today = LocalDate.now();
        createDate = today.minusDays(createDays);
        expiryDate = today.plusDays(expiryDays);
    }

    /**
     * Test checkQuality() method.
     */
    @Test
    public void whenThen() {
        final int limit = 3;
        FreezerWarehouse freezer = new FreezerWarehouse("Freezer", limit);
        RVegetables vegetables = new RVegetables("vegetables", createDate.toString(), expiryDate.toString(), false);
        assertThat(freezer.checkQuality(vegetables), is(true));
    }

    /**
     * Test checkQuality() method.
     */
    @Test
    public void whenThen1() {
        final int limit = 3;
        final double high = 0.85;
        FreezerWarehouse freezer = new FreezerWarehouse("Freezer", limit, high);
        RVegetables vegetables = new RVegetables("vegetables", createDate.toString(), expiryDate.toString(), false);
        assertThat(freezer.checkQuality(vegetables), is(true));
    }
}