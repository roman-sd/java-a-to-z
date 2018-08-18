package ru.sdroman.carstore.service.repository;

import ru.sdroman.carstore.models.DriveType;
import ru.sdroman.carstore.service.Repository;

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
    public List<DriveType> getDriveTypes() {
        return super.execute(session -> (List) session.createQuery("from DriveType").list());
    }

    /**
     * Returns driveType by name.
     *
     * @param name String
     * @return DriveType
     */
    public DriveType getDriveTypeByName(String name) {
        return super.execute(session -> (DriveType) session.createQuery("from DriveType where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }

    /**
     * Returns driveType by id.
     *
     * @param id int
     * @return DriveType
     */
    public DriveType getDriveTypeById(int id) {
        return super.execute(session -> (DriveType) session.createQuery("from DriveType where id=:id")
                .setParameter("id", id)
                .uniqueResult());
    }

    /**
     * Adds driveType to db.
     *
     * @param driveType DriveType
     * @return int driveTypeId
     */
    public int addDriveType(DriveType driveType) {
        return super.execute(session -> (int) session.save(driveType));
    }
}
