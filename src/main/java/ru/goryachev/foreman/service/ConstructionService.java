package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.ConstructionsDAO;
import ru.goryachev.foreman.entities.Construction;
import ru.goryachev.foreman.entities.Entity;

import java.util.List;

@Service
public class ConstructionService implements Applicable {

    @Autowired
    public ConstructionsDAO constructionsDAO;



    @Override
    public List<Construction> getAll() {

        //Check List<>
        List <Construction> co = constructionsDAO.getAll();
        System.out.println("Service check: ready");
        for(Construction stroyka : co) {
            System.out.println("Service check: " + stroyka);
        }
        if (co.isEmpty()){
            System.out.println("Service check: LIST IS EMPTY");
        }

        return constructionsDAO.getAll();
    }

    @Override
    public void save(Entity entity) {
        constructionsDAO.save(entity);
    }

    @Override
    public void update(Entity entity) {
        constructionsDAO.update(entity);
    }

    @Override
    public void delete(int id) {
        constructionsDAO.delete(id);
    }

    public Construction getByName(String name) {
        return constructionsDAO.getByName(name);
    }

    public Construction getById(int id) {
        return constructionsDAO.getById(id);
    }

}
