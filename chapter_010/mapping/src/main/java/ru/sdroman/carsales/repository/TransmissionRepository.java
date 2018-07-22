package ru.sdroman.carsales.repository;

import ru.sdroman.carsales.models.Transmission;

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
        return super.execute(session -> session.createQuery("from ru.sdroman.carsales.models.Transmission").list());
    }

    /**
     * Returns transmission by name.
     *
     * @param name String
     * @return Transmission
     */
    public Transmission getTransmissionByName(String name) {
        return (Transmission) super.execute(session -> session.createQuery("from ru.sdroman.carsales.models.Transmission where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }
}
