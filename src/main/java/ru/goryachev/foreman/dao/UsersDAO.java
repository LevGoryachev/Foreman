package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.User;
import java.util.List;

public class UsersDAO implements DataAccessible {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAll() {
        String sqlQuery = "SELECT * FROM user";
        return jdbcTemplate.query(sqlQuery, new UserMapper());
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
