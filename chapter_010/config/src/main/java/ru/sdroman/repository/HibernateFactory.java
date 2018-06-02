package ru.sdroman.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author sdroman
 * @since 05.2018
 */
public class HibernateFactory {

    /**
     * Session factory.
     */
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    /**
     * Constructor.
     */
    private HibernateFactory() {
    }

    /**
     * Return session factory.
     *
     * @return SessionFactory
     */
    public static SessionFactory getFactory() {
        return factory;
    }
}
