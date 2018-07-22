package ru.sdroman.carsales.repository;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.sdroman.carsales.hibernate.HibernateSessionFactory;

import java.util.function.Function;

/**
 * @author sdroman
 * @since 06.2018
 */
public abstract class Repository {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(Repository.class);

    /**
     * Execute.
     *
     * @param command Function
     * @param <T>     Type
     * @return result
     */
    public <T> T execute(final Function<Session, T> command) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getFactory().openSession();
            session.beginTransaction();
            return command.apply(session);
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            LOG.error(e.getMessage(), e);
            return null;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
            }
        }
    }
}
