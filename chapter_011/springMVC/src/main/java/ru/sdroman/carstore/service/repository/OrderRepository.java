package ru.sdroman.carstore.service.repository;

import ru.sdroman.carstore.models.Car;
import ru.sdroman.carstore.models.Order;
import ru.sdroman.carstore.service.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

/**
 * @author sdroman
 * @since 06.2018
 */
public class OrderRepository extends Repository {

    /**
     * Adds order to db.
     *
     * @param order Order
     * @return int
     */
    public int addOrder(Order order) {
        return super.execute(session -> (int) session.save(order));
    }

    /**
     * Returns order by id.
     *
     * @param id int
     * @return Order
     */
    public Order getOrderById(int id) {
        return super.execute(session -> (Order) session
                .createQuery("from Order where id=:id")
                .setParameter("id", id)
                .uniqueResult());
    }

    /**
     * Updates order.
     *
     * @param order Order
     */
    public void updateOrder(Order order) {
        super.execute(session -> {
            session.saveOrUpdate(order);
            return null;
        });
    }

    /**
     * Returns order list by parameter.
     *
     * @param param Map<String, String>
     * @return List
     */
    public List<Order> getOrdersByParameters(Map<String, String> param) {
        return super.execute(session -> {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Order> query = cb.createQuery(Order.class);
            Root<Order> orderRoot = query.from(Order.class);
            Join<Order, Car> orderCar = orderRoot.join("car");
            Predicate conditions = cb.conjunction();
            for (String key : param.keySet()) {
                if (param.get(key) != null && !param.get(key).equals("")) {
                    if (key.equals("year")) {
                        conditions = cb.and(conditions, cb.equal(orderCar.get("year"), param.get(key)));
                    } else {
                        conditions = cb.and(conditions, cb.equal(orderCar.join(key).get("name"), param.get(key)));
                    }
                }
            }
            query.where(conditions);
            return session.createQuery(query).getResultList();
        });
    }
}
