package ru.sdroman.carsales.repository;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import ru.sdroman.carsales.models.Model;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sdroman
 * @since 07.2018
 */
public class ModelRepositoryTest {

    /**
     * Model class test.
     */
    @Test
    public void modelTest() {
        ModelRepository repository = new ModelRepository();
        Model audi = new Model();
        audi.setName("audi");
        Model bmw = new Model();
        bmw.setName("bmw");

        int expectedId = 1;
        String expectedName = "audi";
        List<Model> expected = new ArrayList<>();
        expected.add(audi);
        expected.add(bmw);

        int actualId = repository.addModel(audi);
        String actualName = repository.getModelByName(expectedName).getName();
        repository.addModel(bmw);
        List<Model> actual = repository.getModels();

        assertThat(actualId, is(expectedId));
        assertThat(actualName, is(expectedName));
        assertThat(actual, is(IsIterableContainingInOrder.contains(expected.toArray())));
    }
}