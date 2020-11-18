package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.Construction;
import ru.goryachev.foreman.entities.Entity;
import java.util.List;

public class ConstructionsDAO implements DataAccessible {

    @Autowired
    public JdbcTemplate jdbcTemplate;


    @Override
    public List<Construction> getAll() {
        final char dm = (char) 34; // double mark, just in case
        String sqlQuery = "SELECT * FROM construction";

        //Check List<>
         List <Construction> co = jdbcTemplate.query(sqlQuery, new ConstructionMapper());
        System.out.println("DAO check: ready");
        for(Construction stroyka : co) {
            System.out.println("DAO check: " + stroyka);
        }
        if (co.isEmpty()){
            System.out.println("DAO check: LIST IS EMPTY");
        }

        return jdbcTemplate.query(sqlQuery, new ConstructionMapper());
    }

    @Override
    public void save(Entity entity) {
        Construction construction = ((Construction) entity);
        String sqlQuery = "INSERT  INTO construction (id, codenumber, name, description) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, construction.getId(), construction.getCodenumber(), construction.getName(), construction.getDescription());
    }

    @Override
    public void update(Entity entity) {
        Construction construction = ((Construction) entity);
        String sqlQuery = "UPDATE construction SET codenumber=?, name=?, description=? WHERE id=?";
        jdbcTemplate.update(sqlQuery, construction.getCodenumber(), construction.getName(), construction.getDescription(), construction.getId());
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "DELETE FROM construction WHERE id=?";
        jdbcTemplate.update(sqlQuery, id);

    }

    public Construction getByName(String name) {
        String sqlQuery = "SELECT * FROM construction WHERE name=?";
        return jdbcTemplate.queryForObject(sqlQuery, new ConstructionMapper(), name);
    }

    public Construction getById(int id) {
        String sqlQuery = "SELECT * FROM construction WHERE id=?";
        return jdbcTemplate.queryForObject(sqlQuery, new ConstructionMapper(), id);
    }

}
