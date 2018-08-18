package ru.sdroman.carstore.service.repository;

import ru.sdroman.carstore.models.Transmission;
import ru.sdroman.carstore.service.Repository;

import java.util.List;

/**
 * @author sdroman
 * @since 06.2018
 */
public class TransmissionRepository extends Repository {

    /**
     * Returns list of transmissions.
     *
     * @return List
     */
    public List<Transmission> getTransmissions() {
        return super.execute(session -> (List) session.createQuery("from Transmission").list());
    }

    public Transmission getTransmissionById(int id) {
        return  super.execute(session -> (Transmission) session
                .createQuery("from Transmission where id=:id")
                .setParameter("id", id)
                .uniqueResult());
    }

    /**
     * Returns transmission by name.
     *
     * @param name String
     * @return Transmission
     */
    public Transmission getTransmissionByName(String name) {
        return super.execute(session -> (Transmission) session
                .createQuery("from Transmission where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }

    /**
     * Adds transmission to db.
     *
     * @param transmission Transmission
     * @return int transmissionId
     */
    public int addTransmission(Transmission transmission) {
        return super.execute(session -> (int) session.save(transmission));
    }
}
