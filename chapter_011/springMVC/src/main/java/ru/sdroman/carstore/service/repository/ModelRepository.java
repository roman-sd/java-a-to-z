package ru.sdroman.carstore.service.repository;


import ru.sdroman.carstore.models.Model;
import ru.sdroman.carstore.service.Repository;

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
        return super.execute(session -> (List) session.createQuery("from Model").list());
    }

    /**
     * Returns model by name.
     *
     * @param name String
     * @return Model
     */
    public Model getModelByName(String name) {
        return super.execute(session -> (Model) session
                .createQuery("from Model where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }

    /**
     * Returns model by id from db.
     *
     * @param id int
     * @return Model
     */
    public Model getModelById(int id) {
        return super.execute(session -> (Model) session
                .createQuery("from Model where id=:id")
                .setParameter("id", id)
                .uniqueResult());
    }

    /**
     * Adds model to db.
     *
     * @param model Model
     * @return int modelId
     */
    public int addModel(Model model) {
        return super.execute(session -> (int) session.save(model));
    }
}
