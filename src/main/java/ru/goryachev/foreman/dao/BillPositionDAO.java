package ru.goryachev.foreman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.goryachev.foreman.entities.BillPosition;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.service.BillPositionService;

import java.util.List;

@Repository
public class BillPositionDAO implements DataAccessible{

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<BillPosition> getAll() {
        //String sqlQuery = "SELECT * FROM billposition";
        String sqlQuery = "SELECT bp.*, c.id AS c_id, c.name AS c_name, c.codenumber, m.name AS m_name, m.um, m.unitweight_kg, m.notes FROM construction c LEFT JOIN  billposition bp ON bp.construction_id=c.id LEFT JOIN material m ON bp.material_id=m.id";
        return jdbcTemplate.query(sqlQuery,new BillPositionMapper());
    }

    //
    @Override
    public void create(Entity entity) {
        BillPosition billPosition = ((BillPosition) entity);
        String sqlQuery = "INSERT  INTO billposition (construction_id, material_id, billqty) VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlQuery, billPosition.getConstructionId(), billPosition.getMaterialId(), billPosition.getBillqty());
    }
    //
    @Override
    public void update(Entity entity) {
    }

    @Override
    public void delete(int id) {
    }

    //Overloaded. It's better to change delete(int id) delete(int...varargs) later
    public void delete(int construction_id, int material_id) {
        String sqlQuery = "DELETE FROM billposition WHERE construction_id=? AND material_id=?";
        jdbcTemplate.update(sqlQuery, construction_id, material_id);
    }

    @Override
    public BillPosition getById(int id) {
        return null;
    }

    public List<BillPosition> getByConstruction(int id) {
        //String sqlQuery = "SELECT * FROM billposition WHERE construction_id=?";
        String sqlQuery = "SELECT bp.*, c.id AS c_id, c.name AS c_name, c.codenumber, m.name AS m_name, m.um, m.unitweight_kg, m.notes FROM construction c LEFT JOIN  billposition bp ON bp.construction_id=c.id LEFT JOIN material m ON bp.material_id=m.id WHERE c.id=?";
        return jdbcTemplate.query(sqlQuery, new BillPositionMapper(), id);
    }
}
