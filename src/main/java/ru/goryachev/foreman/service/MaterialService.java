package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.MaterialsDAO;
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

}
