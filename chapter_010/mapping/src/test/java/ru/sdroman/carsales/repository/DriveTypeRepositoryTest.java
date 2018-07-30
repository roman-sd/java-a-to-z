package ru.sdroman.carsales.repository;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import ru.sdroman.carsales.models.DriveType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sdroman
 * @since 07.2018
 */
public class DriveTypeRepositoryTest {

    /**
     * DriveType method test.
     */
    @Test
    public void driveTypeTest() {
        DriveTypeRepository repository = new DriveTypeRepository();
        DriveType rear = new DriveType();
        rear.setName("rear-wheel-drive");
        DriveType front = new DriveType();
        front.setName("front-wheel-drive");

        int expectedId = 1;
        String expectedName = "rear-wheel-drive";
        List<DriveType> expected = new ArrayList<>();
        expected.add(rear);
        expected.add(front);

        int actualId = repository.addDriveType(rear);
        String actualName = repository.getDriveTypeByName(expectedName).getName();
        repository.addDriveType(front);
        List<DriveType> actual = repository.getDriveTypies();

        assertThat(actualId, is(expectedId));
        assertThat(actualName, is(expectedName));
        assertThat(actual, is(IsIterableContainingInOrder.contains(expected.toArray())));
    }
}