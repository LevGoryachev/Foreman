package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.Construction;

import java.util.ArrayList;
import java.util.List;

public class ConstructionsDAO implements DataAccessible {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public ConstructionsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Construction getByName(String name) {
        String sqlQuery = "SELECT * FROM construction WHERE name=?";
        return jdbcTemplate.queryForObject(sqlQuery, new ConstructionMapper(), name);
    }

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


}
