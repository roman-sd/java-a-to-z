package ru.sdroman.carstore.service.repository;

import ru.sdroman.carstore.models.Body;
import ru.sdroman.carstore.service.Repository;

import java.util.List;

/**
 * @author sdroman
 * @since 06.2018
 */
public class BodyRepository extends Repository {

    /**
     * Returns list of bodies.
     *
     * @return List
     */
    public List<Body> getBodies() {
        return super.execute(session -> (List) session.createQuery("from Body").list());
    }

    /**
     * Returns body by name.
     *
     * @param name String
     * @return Body
     */
    public Body getBodyByName(String name) {
        return super.execute(session -> (Body) session
                .createQuery("from Body where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }

    /**
     * Returns body by id.
     *
     * @param id int
     * @return Body
     */
    public Body getBodyById(int id) {
        return super.execute(session -> (Body) session
                .createQuery("from Body where id=:id")
                .setParameter("id", id)
                .uniqueResult());
    }

    /**
     * Adds new body to db.
     *
     * @param body Body
     * @return int bodyId
     */
    public int addBody(Body body) {
        return (int) super.execute(session -> session.save(body));
    }
}
