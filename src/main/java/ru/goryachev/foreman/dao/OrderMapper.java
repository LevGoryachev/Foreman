package ru.goryachev.foreman.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.goryachev.foreman.entities.Order;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setConstructionId(rs.getInt("construction_id"));
        order.setOrdertime(rs.getTimestamp("ordertime").toLocalDateTime());
        order.setPosted(rs.getBoolean("posted"));
        order.setSent(rs.getBoolean("sent"));
        order.setStatusExecuted(rs.getBoolean("status_executed"));
        order.setAppUserId(rs.getInt("app_user_id"));
        return order;
    }
}
