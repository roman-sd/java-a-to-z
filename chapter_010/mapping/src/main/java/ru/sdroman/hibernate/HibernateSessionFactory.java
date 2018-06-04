package ru.sdroman.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author sdroman
 * @since 06.2018
 */
public class HibernateSessionFactory {

    /**
     * Session factory.
     */
    private static SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    /**
     * Constructor.
     */
    private HibernateSessionFactory() {
    }

    /**
     * Returns session.
     *
     * @return SessionFactory
     */
    public static SessionFactory getFactory() {
        return factory;
    }
}
