package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Order;

import java.util.List;

@Repository
public class OrdersDAO implements DataAccessible {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> getAll() {
        char dm = 34;
        String sqlQuery = "SELECT * FROM " + dm + "order" + dm;
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }

    @Override
    public void create(Entity entity) {
        Order order = ((Order) entity);
        char dm = 34;
        String sqlQuery = "INSERT  INTO " + dm + "order" + dm + " (construction_id, ordertime, posted, sent, status_executed, app_user_id) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, order.getConstructionId(), order.getOrdertime(), order.isPosted(), order.isSent(), order.isStatusExecuted(), order.getAppUserId());
    }

    @Override
    public void update(Entity entity) {
        Order order = ((Order) entity);
        char dm = 34;
        String sqlQuery = "UPDATE " + dm + "order" + dm + " SET posted=?, sent=?, status_executed=? WHERE id=?";
        jdbcTemplate.update(sqlQuery, order.isPosted(), order.isSent(), order.isStatusExecuted(), order.getId());
    }

    @Override
    public void delete(int id) {
        char dm = 34;
        String sqlQuery = "DELETE FROM " + dm + "order" + dm + " WHERE id=?";
        jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public Order getById(int id) {
        char dm = 34;
        String sqlQuery = "SELECT * FROM " + dm + "order" + dm + " WHERE id=?";
        return jdbcTemplate.queryForObject(sqlQuery, new OrderMapper(), id);
    }

    /* //sample
    public List<Order> getChangeable(int constructionId) {
        char dm = 34;
        String sqlQuery = "SELECT * FROM " + dm + "order" + dm + " WHERE posted = false AND sent = false AND status_executed = false AND construction_id = ?";
        return jdbcTemplate.query(sqlQuery, new OrderMapper(), constructionId);
    }
     */
}
