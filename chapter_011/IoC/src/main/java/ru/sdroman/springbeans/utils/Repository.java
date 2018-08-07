package ru.sdroman.springbeans.utils;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author sdroman
 * @since 08.2018
 */
public abstract class Repository {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(Repository.class);

    /**
     * Applies this function to the given session.
     *
     * @param command Command
     * @param <T>     the type of the input to the function
     * @return T result
     */
    public <T> T execute(final Function<Session, T> command) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
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

    /**
     * Performs this operation on the given session.
     *
     * @param command Consumer
     */
    public void execute(final Consumer<Session> command) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            command.accept(session);
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            LOG.error(e.getMessage(), e);
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
            }
        }
    }
}
