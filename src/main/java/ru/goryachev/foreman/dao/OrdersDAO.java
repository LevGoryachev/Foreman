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
        String sqlQuery = "SELECT * FROM order";
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }

    @Override
    public void save(Entity entity) {
        Order order = ((Order) entity);
        String sqlQuery = "INSERT  INTO order (id, construction_id, ordertime, posted, sent, status_executed, app_user_id) VALUES (?, ?, ?, false, false, false, ?)";
        jdbcTemplate.update(sqlQuery, order.getId(), order.getConstructionId(), order.getOrdertime(), order.getAppUserId());
    }

    @Override
    public void update(Entity entity) {
        Order order = ((Order) entity);
        String sqlQuery = "UPDATE order SET posted=?, sent=?, status_executed=? WHERE id=?";
        jdbcTemplate.update(sqlQuery, order.isPosted(), order.isSent(), order.isStatusExecuted(), order.getId());
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "DELETE FROM order WHERE id=?";
        jdbcTemplate.update(sqlQuery, id);
    }

    //lists for employers
    public List<Order> getChangeable(int constructionId) {
        String sqlQuery = "SELECT * FROM order WHERE posted = false AND sent = false AND status_executed = false AND construction_id = ?";
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }

    public List<Order> getPosted(int constructionId) {
        String sqlQuery = "SELECT * FROM order WHERE posted = true AND sent = false AND status_executed = false AND construction_id = ?";
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }

    public List<Order> getSent(int constructionId) {
        String sqlQuery = "SELECT * FROM order WHERE posted = true AND sent = true AND status_executed = false AND construction_id = ?";
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }

    public List<Order> getExecuted(int constructionId) {
        String sqlQuery = "SELECT * FROM order WHERE status_executed = true AND construction_id = ?";
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }


    //lists for suppliers
    public List<Order> getPostedAll() {
        String sqlQuery = "SELECT * FROM order WHERE posted = true AND sent = false AND status_executed = false";
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }

    public List<Order> getSentAll() {
        String sqlQuery = "SELECT * FROM order WHERE posted = true AND sent = true AND status_executed = false";
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }

    public List<Order> getExecutedAll() {
        String sqlQuery = "SELECT * FROM order WHERE status_executed = true";
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }
}
