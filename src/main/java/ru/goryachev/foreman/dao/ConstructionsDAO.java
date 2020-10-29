package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.Construction;
import java.util.List;

public class ConstructionsDAO implements DataAccessible {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public ConstructionsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Construction> getAll() {
        String sqlQuery = "SELECT * FROM construction";
        return jdbcTemplate.query(sqlQuery, new ConstructionMapper());
    }
}
