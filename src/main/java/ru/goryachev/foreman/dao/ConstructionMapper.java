package ru.goryachev.foreman.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.goryachev.foreman.entities.Construction;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConstructionMapper implements RowMapper<Construction> {
    @Override
    public Construction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Construction construction = new Construction();
        construction.setId(rs.getInt("id"));
        construction.setCodenumber(rs.getString("codenumber"));
        construction.setName(rs.getString("name"));
        construction.setDescription(rs.getString("description"));
        return construction;
    }
}
