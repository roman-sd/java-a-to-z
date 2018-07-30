package ru.sdroman.carsales.repository;

import ru.sdroman.carsales.models.DriveType;

import java.util.List;

/**
 * @author sdroman
 * @since 06.2018
 */
public class DriveTypeRepository extends Repository {

    /**
     * Returns list of driveType.
     *
     * @return List
     */
    public List<DriveType> getDriveTypies() {
        return super.execute(session -> session.createQuery("from ru.sdroman.carsales.models.DriveType").list());
    }

    /**
     * Returns driveType by name.
     *
     * @param name String
     * @return DriveType
     */
    public DriveType getDriveTypeByName(String name) {
        return (DriveType) super.execute(session -> session.createQuery("from ru.sdroman.carsales.models.DriveType where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }

    /**
     * Adds driveType to db.
     *
     * @param driveType DriveType
     * @return int driveTypeId
     */
    public int addDriveType(DriveType driveType) {
        return (int) super.execute(session -> session.save(driveType));
    }
}
