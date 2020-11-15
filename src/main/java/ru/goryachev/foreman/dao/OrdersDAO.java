package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Order;

import java.util.List;

public class OrdersDAO implements DataAccessible {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrdersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Order> getAll() {
        String sqlQuery = "SELECT * FROM order";
        return jdbcTemplate.query(sqlQuery, new OrderMapper());
    }

    @Override
    public void save(Entity entity) {

    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(int id) {

    }
}
