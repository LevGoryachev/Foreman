package ru.goryachev.foreman.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.goryachev.foreman.entities.Role;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setRank(rs.getString("rank"));
        return role;
    }
}
