package ru.sdroman.carsales.repository;

import ru.sdroman.carsales.models.Engine;

import java.util.List;

/**
 * @author sdroman
 * @since 06.2018
 */
public class EngineRepository extends Repository {

    /**
     * Returns list of engine.
     *
     * @return List
     */
    public List<Engine> getEngines() {
        return super.execute(session -> session.createQuery("from ru.sdroman.carsales.models.Engine").list());
    }

    /**
     * Returns engine by name.
     *
     * @param name String
     * @return Engine
     */
    public Engine getEngineByName(String name) {
        return (Engine) super.execute(session -> session.createQuery("from ru.sdroman.carsales.models.Engine where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }
}
