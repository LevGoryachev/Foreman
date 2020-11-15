package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.Construction;
import ru.goryachev.foreman.entities.Entity;
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

    @Override
    public void save(Entity entity) {
        Material material = ((Material) entity);
        String sqlQuery = "INSERT  INTO material (id, name, um, unitweight_kg, notes) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, material.getId(), material.getName(), material.getUm(), material.getUnitWkg(), material.getNotes());
    }

    @Override
    public void update(Entity entity) {
        Material material = ((Material) entity);
        String sqlQuery = "UPDATE material SET name=?, um=?, unitweight_kg=?, notes=? WHERE id=?";
        jdbcTemplate.update(sqlQuery, material.getName(), material.getUm(), material.getUnitWkg(), material.getNotes(), material.getId());
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "DELETE FROM material WHERE id=?";
        jdbcTemplate.update(sqlQuery, id);

    }

    public Material getById(int id) {
        String sqlQuery = "SELECT * FROM material WHERE id=?";
        return jdbcTemplate.queryForObject(sqlQuery, new MaterialMapper(), id);
    }
}
