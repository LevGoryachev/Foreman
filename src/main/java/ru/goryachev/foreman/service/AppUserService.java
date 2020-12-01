package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.AppUsersDAO;
import ru.goryachev.foreman.entities.AppUser;
import ru.goryachev.foreman.entities.Entity;
import java.util.List;

@Service
public class AppUserService implements Applicable {

    @Autowired
    public AppUsersDAO appUsersDAO;

    @Override
    public List<AppUser> getAll() {
        return appUsersDAO.getAll();
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

    public AppUser getById(int id) {
        return appUsersDAO.getById(id);
    }

}
