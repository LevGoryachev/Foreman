package ru.goryachev.foreman.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.goryachev.foreman.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("firstname"));
        user.setMiddleName(rs.getString("middlename"));
        user.setLastName(rs.getString("lastname"));
        user.setNickName(rs.getString("nickname"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
