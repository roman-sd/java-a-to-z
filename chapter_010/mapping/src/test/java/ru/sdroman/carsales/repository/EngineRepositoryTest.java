package ru.sdroman.carsales.repository;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import ru.sdroman.carsales.models.Engine;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sdroman
 * @since 07.2018
 */
public class EngineRepositoryTest {

    /**
     * Engine class test.
     */
    @Test
    public void engineTest() {
        EngineRepository repository = new EngineRepository();
        Engine diesel = new Engine();
        diesel.setName("diesel");
        Engine petrol = new Engine();
        petrol.setName("petrol");

        int expectedId = 1;
        String expectedName = "diesel";
        List<Engine> expected = new ArrayList<>();
        expected.add(diesel);
        expected.add(petrol);

        int actualId = repository.addEngine(diesel);
        String actualName = repository.getEngineByName(expectedName).getName();
        repository.addEngine(petrol);
        List<Engine> actual = repository.getEngines();

        assertThat(actualId, is(expectedId));
        assertThat(actualName, is(expectedName));
        assertThat(actual, is(IsIterableContainingInOrder.contains(expected.toArray())));
    }
}