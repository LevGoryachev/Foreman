package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.MaterialsDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Material;
import java.util.List;

@Service
public class MaterialService implements Applicable {

    @Autowired
    public MaterialsDAO materialsDAO;

    @Override
    public List<Material> getAll() {
        return materialsDAO.getAll();
    }

    @Override
    public void save(Entity entity) {
        materialsDAO.save(entity);
    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(int id) {

    }

}
