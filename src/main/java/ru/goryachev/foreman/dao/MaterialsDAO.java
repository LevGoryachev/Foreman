package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.Material;
import java.util.List;

public class MaterialsDAO implements DataAccessible {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public MaterialsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Material> getAll() {
        String sqlQuery = "SELECT * FROM material";
        return jdbcTemplate.query(sqlQuery, new MaterialMapper());
    }
}
