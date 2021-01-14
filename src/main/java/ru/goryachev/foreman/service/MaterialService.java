package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.MaterialsDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Material;
import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialsDAO materialsDAO;

    public List<Material> getAll() {
        return materialsDAO.getAll();
    }

    public void create(Entity entity) {
        materialsDAO.create(entity);
    }

    public void update(Entity entity) {
        materialsDAO.update(entity);
    }

    public void delete(int id) {
        materialsDAO.delete(id);
    }

    public Material getById(int id) {
        return materialsDAO.getById(id);
    }

}
