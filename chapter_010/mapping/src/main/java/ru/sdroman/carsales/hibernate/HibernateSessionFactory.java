package ru.sdroman.carsales.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author sdroman
 * @since 06.2018
 */
public class HibernateSessionFactory {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(HibernateSessionFactory.class);

    /**
     * Session factory.
     */
    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * @return SessionFactory
     */
    public static SessionFactory getFactory() {
        return factory;
    }
}
