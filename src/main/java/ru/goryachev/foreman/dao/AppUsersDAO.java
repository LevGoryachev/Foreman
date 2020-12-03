package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.AppUser;
import java.util.List;

public class AppUsersDAO implements DataAccessible {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<AppUser> getAll() {
        String sqlQuery = "SELECT * FROM app_user";
        return jdbcTemplate.query(sqlQuery, new AppUserMapper());
    }

    @Override
    public void save(Entity entity) {
        AppUser appUser = ((AppUser)entity);
        String sqlQuery = "INSERT INTO app_user (id, firstname, middlename, lastname, nickname, password, role_id) values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, appUser.getId(), appUser.getFirstName(), appUser.getMiddleName(), appUser.getLastName(), appUser.getNickName(), appUser.getPassword(), appUser.getRoleId());

    }

    @Override
    public void update(Entity entity) {
        AppUser appUser = ((AppUser) entity);
        String sqlQuery = "UPDATE app_user SET firstname=?, middlename=?, lastname=?, nickname=?, password=?, role_id=? WHERE id=?";
        jdbcTemplate.update(sqlQuery, appUser.getFirstName(), appUser.getMiddleName(), appUser.getLastName(), appUser.getNickName(), appUser.getPassword(), appUser.getRoleId(), appUser.getId());
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "DELETE FROM app_user WHERE id=?";
        jdbcTemplate.update(sqlQuery, id);
    }

    public AppUser getById(int id) {
        String sqlQuery = "SELECT * FROM app_user WHERE id=?";
        return jdbcTemplate.queryForObject(sqlQuery, new AppUserMapper(), id);
    }
}
