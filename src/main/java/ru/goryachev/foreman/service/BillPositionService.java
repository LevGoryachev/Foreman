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

    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(int id) {

    }

}
