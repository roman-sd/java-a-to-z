package ru.sdroman.carsales.repository;

import ru.sdroman.carsales.models.Model;

import java.util.List;

/**
 * @author sdroman
 * @since 06.2018
 */
public class ModelRepository extends Repository {

    /**
     * Returns list of model.
     *
     * @return List
     */
    public List<Model> getModels() {
        return super.execute(session -> session.createQuery("from ru.sdroman.carsales.models.Model").list());
    }

    /**
     * Returns model by name.
     *
     * @param name String
     * @return Model
     */
    public Model getModelByName(String name) {
        return (Model) super.execute(session -> session.createQuery("from ru.sdroman.carsales.models.Model where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }
}
