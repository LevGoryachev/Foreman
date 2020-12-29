package ru.goryachev.foreman.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.goryachev.foreman.entities.BillPosition;
import ru.goryachev.foreman.entities.OrderPosition;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderPositionMapper implements RowMapper<OrderPosition> {
    @Override
    public OrderPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderPosition orderPosition = new OrderPosition();
        orderPosition.setConstructionid(rs.getInt("construction_id"));
        orderPosition.setMaterialid(rs.getInt("material_id"));
        orderPosition.setOrderid(rs.getInt("order_id"));
        orderPosition.setOrderqty(rs.getInt("orderqty"));
        return orderPosition;
    }
}
