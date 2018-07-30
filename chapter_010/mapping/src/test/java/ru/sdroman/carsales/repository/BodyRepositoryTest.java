package ru.sdroman.carsales.repository;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import ru.sdroman.carsales.models.Body;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sdroman
 * @since 07.2018
 */
public class BodyRepositoryTest {

    /**
     * Body class test.
     */
    @Test
    public void bodyTest() {
        BodyRepository repository = new BodyRepository();
        Body coupeBody = new Body();
        Body sedanBody = new Body();
        coupeBody.setName("coupe");
        sedanBody.setName("sedan");

        int expectedId = 1;
        String expectedName = "coupe";
        List<Body> expected = new ArrayList<>();
        expected.add(coupeBody);
        expected.add(sedanBody);

        int actualId = repository.addBody(coupeBody);
        String actualName = repository.getBodyByName(expectedName).getName();
        repository.addBody(sedanBody);
        List<Body> actual = repository.getBodies();

        assertThat(actualId, is(expectedId));
        assertThat(actualName, is(expectedName));
        assertThat(actual, is(IsIterableContainingInOrder.contains(expected.toArray())));
    }
}