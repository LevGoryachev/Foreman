package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.goryachev.foreman.entities.BillPosition;
import ru.goryachev.foreman.entities.Entity;
import java.util.List;

public class BillPositionDAO implements DataAccessible{

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<BillPosition> getAll() {
        String sqlQuery = "SELECT * FROM billposition";
        return jdbcTemplate.query(sqlQuery,new BillPositionMapper());
    }

    //
    @Override
    public void save(Entity entity) {
        BillPosition billPosition = ((BillPosition) entity);
        String sqlQuery = "INSERT  INTO billposition (construction_id, material_id, billqty) VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlQuery, billPosition.getConstructionId(), billPosition.getMaterialId(), billPosition.getBillqty());
    }
    //
    @Override
    public void update(Entity entity) {

    }
    //
    @Override
    public void delete(int material_id) {
        String sqlQuery = "DELETE FROM billposition WHERE material_id=?";
        jdbcTemplate.update(sqlQuery, material_id);
    }

    public List<BillPosition> getByConstruction(int id) {
        //String sqlQuery = "SELECT * FROM billposition WHERE construction_id=?";
        //String sqlQuery = "SELECT bp.*, c.name AS c_name FROM billposition bp INNER JOIN construction c ON bp.construction_id=c.id AND bp.construction_id=?";
        String sqlQuery = "SELECT bp.*, c.id AS c_id, c.name AS c_name, c.codenumber, m.name AS m_name, m.um, m.unitweight_kg, m.notes FROM construction c LEFT JOIN  billposition bp ON bp.construction_id=c.id LEFT JOIN material m ON bp.material_id=m.id WHERE c.id=?";
        return jdbcTemplate.query(sqlQuery, new BillPositionMapper(), id);
    }

}
