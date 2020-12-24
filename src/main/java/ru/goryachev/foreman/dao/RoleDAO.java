package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Role;

import java.util.List;

@Repository
public class RoleDAO implements DataAccessible {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Role> getAll() {
        String sqlQuery = "SELECT * FROM role";
        return jdbcTemplate.query(sqlQuery, new RoleMapper());
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
