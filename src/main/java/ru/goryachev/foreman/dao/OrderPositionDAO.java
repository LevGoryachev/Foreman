package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.OrderPosition;

import java.util.List;

public class OrderPositionDAO implements DataAccessible {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderPositionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<OrderPosition> getAll() {
        String sqlQuery = "SELECT * FROM orderposition";
        return jdbcTemplate.query(sqlQuery,new OrderPositionMapper());
    }
}
