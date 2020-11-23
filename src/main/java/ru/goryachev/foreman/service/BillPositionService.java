package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.BillPositionDAO;
import ru.goryachev.foreman.entities.BillPosition;
import ru.goryachev.foreman.entities.Entity;

import java.util.List;

@Service
public class BillPositionService implements Applicable {

    @Autowired
    public BillPositionDAO billPositionDAO;

    @Override
    public List<BillPosition> getAll() {
        return billPositionDAO.getAll();
    }

    @Override
    public void save(Entity entity) {
        billPositionDAO.save(entity);
    }

    @Override
    public void update(Entity entity) {
        //BillPosition was not supposed to be update for a while
    }

    @Override
    public void delete(int id) {
    }

    //Overloaded. It's better to change delete (int id) delete(int...varargs) later
    public void delete(int construction_id, int material_id) {
        billPositionDAO.delete(construction_id, material_id);
    }

    public List<BillPosition> getByConstruction (int id) {
        return billPositionDAO.getByConstruction(id);
    }
}
