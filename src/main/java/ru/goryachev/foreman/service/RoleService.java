package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.goryachev.foreman.dao.RoleDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Role;

import java.util.List;

public class RoleService implements Applicable {

    @Autowired
    public RoleDAO roleDAO;

    @Override
    public List<Role> getAll() {
        return roleDAO.getAll();
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
