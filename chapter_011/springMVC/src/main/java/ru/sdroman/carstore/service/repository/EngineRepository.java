package ru.sdroman.carstore.service.repository;

import ru.sdroman.carstore.models.Engine;
import ru.sdroman.carstore.service.Repository;

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
        return super.execute(session -> (List) session.createQuery("from Engine").list());
    }

    /**
     * Returns engine by id.
     *
     * @param id int
     * @return Engine
     */
    public Engine getEngineById(int id) {
        return (Engine) super.execute(session -> session.createQuery("from Engine where id=:id")
                .setParameter("id", id)
                .uniqueResult());
    }

    /**
     * Returns engine by name.
     *
     * @param name String
     * @return Engine
     */
    public Engine getEngineByName(String name) {
        return super.execute(session -> (Engine) session
                .createQuery("from Engine where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }

    /**
     * Adds engine to db.
     *
     * @param engine Engine
     * @return int engineId
     */
    public int addEngine(Engine engine) {
        return super.execute(session -> (int) session.save(engine));
    }
}
