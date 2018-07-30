package ru.sdroman.carsales.repository;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import ru.sdroman.carsales.models.Transmission;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sdroman
 * @since 07.2018
 */
public class TransmissionRepositoryTest {

    /**
     * Transmission class test.
     */
    @Test
    public void transmissionTest() {
        TransmissionRepository repository = new TransmissionRepository();
        Transmission auto = new Transmission();
        auto.setName("automatic");
        Transmission manual = new Transmission();
        manual.setName("manual");

        int expectedId = 1;
        String expectedName = "automatic";
        List<Transmission> expected = new ArrayList<>();
        expected.add(auto);
        expected.add(manual);

        int actualId = repository.addTransmission(auto);
        String actualName = repository.getTransmissionByName(expectedName).getName();
        repository.addTransmission(manual);
        List<Transmission> actual = repository.getTransmissions();

        assertThat(actualId, is(expectedId));
        assertThat(actualName, is(expectedName));
        assertThat(actual, is(IsIterableContainingInOrder.contains(expected.toArray())));
    }
}