package ru.goryachev.foreman.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.goryachev.foreman.entities.BillPosition;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillPositionMapper implements RowMapper<BillPosition> {

    @Override
    public BillPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
        BillPosition billPosition = new BillPosition();
        billPosition.setConstructionId(rs.getInt("construction_id"));
        billPosition.setMaterialId(rs.getInt("material_id"));
        billPosition.setBillqty(rs.getInt("billqty"));

        //fields from JOIN query:
        billPosition.setEntityConstructionId(rs.getInt("c_id")); //c_id - is an alias of field of table "construction"
        billPosition.setEntityConstructionName(rs.getString("c_name"));       //c_name - is an alias of field of table "construction"
        billPosition.setEntityConstructionCodeNumber(rs.getString("codenumber"));       //is a field of table "construction"

        billPosition.setEntityMaterialName(rs.getString("m_name"));           //m_name - is an alias of field of table "material"
        billPosition.setEntityMaterialUm(rs.getString("um"));                 //is a field of table "material"
        billPosition.setEntityMaterialUnitWkg(rs.getInt("unitweight_kg"));    //is a field of table "material"
        billPosition.setEntityMaterialNotes(rs.getString("notes"));           //is a field of table "material"
        return billPosition;
    }
}
