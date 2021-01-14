package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.RoleDAO;
import ru.goryachev.foreman.entities.Role;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public List<Role> getAll() {
        return roleDAO.getAll();
    }
}
