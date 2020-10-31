package ru.goryachev.foreman.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.goryachev.foreman.entities.BillPosition;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillPositionMapper implements RowMapper<BillPosition> {
    @Override
    public BillPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
        BillPosition billPosition = new BillPosition();
        billPosition.setConstructionid(rs.getInt("construction_id"));
        billPosition.setMaterialid(rs.getInt("material_id"));
        billPosition.setBillqty(rs.getInt("billqty"));
        return billPosition;
    }
}
