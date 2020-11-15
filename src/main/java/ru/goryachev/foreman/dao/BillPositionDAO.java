package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.BillPosition;
import ru.goryachev.foreman.entities.Entity;

import java.util.List;

public class BillPositionDAO implements DataAccessible{

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public BillPositionDAO (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BillPosition> getAll() {
        String sqlQuery = "SELECT * FROM billposition";
        return jdbcTemplate.query(sqlQuery,new BillPositionMapper());
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
