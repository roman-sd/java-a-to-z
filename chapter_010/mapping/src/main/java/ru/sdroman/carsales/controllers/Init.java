package ru.sdroman.carsales.controllers;

import ru.sdroman.carsales.hibernate.HibernateSessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author sdroman
 * @since 07.2018
 */
public class Init implements ServletContextListener {

    /**
     * Initialize.
     * @param servletContextEvent ServletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HibernateSessionFactory.getFactory();
    }

    /**
     * Destroy.
     * @param servletContextEvent ServletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
