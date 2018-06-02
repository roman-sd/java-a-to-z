package ru.sdroman.repository;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sdroman.models.Item;

import java.util.Collection;
import java.util.List;


/**
 * @author sdroman
 * @since 05.2018
 */
public class ItemRepository {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(ItemRepository.class);

    /**
     * Session factory.
     */
    private final SessionFactory factory = HibernateFactory.getFactory();

    /**
     * Creates item.
     *
     * @param item Item
     */
    public void create(final Item item) {

        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            session.save(item);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.error(e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    /**
     * Returns item list.
     *
     * @return Collection
     */
    public Collection<Item> getItems() {
        List<Item> items = null;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            items = session.createQuery("from ru.sdroman.models.Item").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return items;
    }
}
