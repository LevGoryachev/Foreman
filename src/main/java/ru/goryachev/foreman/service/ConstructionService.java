package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.ConstructionsDAO;
import ru.goryachev.foreman.entities.Construction;
import java.util.List;

@Service
public class ConstructionService implements Applicable {

    @Autowired
    public ConstructionsDAO constructionsDAO;

    @Override
    public List<Construction> getAll() {
        return constructionsDAO.getAll();
    }

}
