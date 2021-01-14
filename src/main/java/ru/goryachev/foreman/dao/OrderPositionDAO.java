package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.goryachev.foreman.entities.BillPosition;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.OrderPosition;

import java.util.List;

@Repository
public class OrderPositionDAO implements DataAccessible {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<OrderPosition> getAll() {
        String sqlQuery = "SELECT * FROM orderposition";
        return jdbcTemplate.query(sqlQuery,new OrderPositionMapper());
    }

    @Override
    public void create(Entity entity) {
        OrderPosition orderPosition = ((OrderPosition) entity);
        String sqlQuery = "INSERT INTO orderposition (construction_id, material_id, order_id, status_delivered, orderqty) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, orderPosition.getConstructionid(), orderPosition.getMaterialid(), orderPosition.getOrderid(), orderPosition.isStatusDelivered(), orderPosition.getOrderqty());
    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(int id) {
    }

    //Overloaded. It's better to change delete(int id) delete(int...varargs) later
    public void delete(int construction_id, int material_id, int order_id) {
        String sqlQuery = "DELETE FROM orderposition WHERE construction_id=? AND material_id=? AND order_id=?";
        jdbcTemplate.update(sqlQuery, construction_id, material_id, order_id);
    }

    @Override
    public OrderPosition getById(int id) {
        return null;
    }
}
