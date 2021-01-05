package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.RoleDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Role;

import java.util.List;

@Service
public class RoleService implements Applicable {

    @Autowired
    public RoleDAO roleDAO;

    @Override
    public List<Role> getAll() {
        return roleDAO.getAll();
    }

    @Override
    public void create(Entity entity) {

    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(int id) {

    }
}
