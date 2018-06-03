package ru.sdroman.repository;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sdroman.models.Item;

import java.util.List;
import java.util.function.Function;


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
     * Transaction.
     *
     * @param command hibernate command
     * @param <T>     Item
     * @return result
     */
    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tr = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            LOG.error(e.getMessage(), e);
            return null;
        } finally {
            if (tr != null) {
                tr.commit();
            }
            session.close();
        }
    }

    /**
     * Creates item.
     *
     * @param item Item
     */
    public void create(Item item) {
        tx(session -> session.save(item));
    }

    /**
     * Returns item list.
     *
     * @return Collection
     */
    public List<Item> getItems() {
        return tx(session -> session.createQuery("from ru.sdroman.models.Item").list());
    }
}
