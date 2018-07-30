package ru.sdroman.carsales.repository;

import ru.sdroman.carsales.models.Body;

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
        return super.execute(session -> session.createQuery("from Body").list());
    }

    /**
     * Returns body by name.
     *
     * @param name String
     * @return Body
     */
    public Body getBodyByName(String name) {
        return (Body) super.execute(session -> session.createQuery("from Body where name=:name")
                .setParameter("name", name)
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
