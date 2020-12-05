package ru.goryachev.foreman.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.goryachev.foreman.entities.AppUser;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserMapper implements RowMapper<AppUser> {
    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        AppUser appUser = new AppUser();
        appUser.setId(rs.getInt("id"));
        appUser.setFirstName(rs.getString("firstname"));
        appUser.setMiddleName(rs.getString("middlename"));
        appUser.setLastName(rs.getString("lastname"));
        appUser.setLogin(rs.getString("login"));
        appUser.setPassword(rs.getString("password"));
        appUser.setRoleId(rs.getInt("role_id"));

        //field from JOIN query:
        appUser.setEntityRoleRank(rs.getString("r_rank"));//r_rank - is an alias of field of table "role"
        return appUser;
    }
}
